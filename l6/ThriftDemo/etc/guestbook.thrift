namespace java test.gen

struct Entry {
	1: i32 uid,
	2: string name,
	3: string blurb
}

service Guestbook {
	void store(1:Entry entry),
	Entry findEntries(1:string keywords),
	Entry fetch(1:i32 uid),
	void update(1:Entry entry),
}