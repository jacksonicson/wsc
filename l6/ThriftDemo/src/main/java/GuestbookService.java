
import org.apache.thrift.TException;

import test.gen.Entry;
import test.gen.Guestbook;

public class GuestbookService implements Guestbook.Iface {

	@Override
	public void store(Entry entry) throws TException {
		System.out.println("Store entry: " + entry.getName());
	}

	@Override
	public Entry findEntries(String keywords) throws TException {
		return null;
	}

	@Override
	public Entry fetch(int uid) throws TException {
		return null;
	}

	@Override
	public void update(Entry entry) throws TException {
		System.out.println("Update entry: " + entry.getName());
	}

}
