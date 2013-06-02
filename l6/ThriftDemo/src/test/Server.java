package test;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TServlet;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import test.gen.Guestbook;

public class Server {

	public Server() throws TTransportException {
		// Message processor (deligates messages to guestbook service
		// implementation)
		Guestbook.Processor<GuestbookService> processor = new Guestbook.Processor<GuestbookService>(
				new GuestbookService());

		// Use plain socket for transport
		TServerTransport serverTransport = new TServerSocket(9090);

		// Protocol
		TProtocolFactory factory = new TBinaryProtocol.Factory();
		factory = new TJSONProtocol.Factory(); 
		
		// Start server with transport and processor
		Args args = new Args(serverTransport);
		args.processor(processor);
		args.protocolFactory(factory); 
		TServer server = new TSimpleServer(args);

		System.out.println("Start server...");
		server.serve();
	}

	public static void main(String arg[]) {
		try {
			new Server();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}
