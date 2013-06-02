package test;

import java.io.UnsupportedEncodingException;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TMemoryBuffer;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import test.gen.Entry;
import test.gen.Guestbook;

public class Client {

	public Client() throws TException, UnsupportedEncodingException {
		// Open transport layer
		TTransport transport = new TSocket("localhost", 9090);
		transport.open();

		// Create new protocol
		TProtocol protocol = new TBinaryProtocol(transport);
		protocol = new TJSONProtocol(transport); 

		// New client which is attached to the protocol
		Guestbook.Client client = new Guestbook.Client(protocol);

		Entry entry = new Entry();
		entry.setUid(100);
		entry.setName("a test entry");
		client.store(entry);
		
		serializerTest(entry); 
	}

	private void serializerTest(Entry entry) throws TException, UnsupportedEncodingException {
		TMemoryBuffer transport = new TMemoryBuffer(1000);
		TProtocol protocol = new TBinaryProtocol(transport);
//		TProtocol protocol = new TJSONProtocol(transport);
		entry.write(protocol);
		System.out.println(transport.toString("utf8"));
		
		Entry newEntry = new Entry();
		newEntry.read(protocol); 
		System.out.println("Deserialized name: " + newEntry.getName()); 
	}

	public static void main(String arg[]) {
		try {
			new Client();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
