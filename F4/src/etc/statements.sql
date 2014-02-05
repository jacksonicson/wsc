### Inserts
insert into user (surname, lastname, age, birth) values ('james', 'brown', 33, '1981-01-01');
select * from user;

# each insert generates a new identifier!
# use the identifier form the users in the address insert command 

insert into address (city, plz, street, housenumber, userid) value ('munic', '43434', 'sonnenweg', '3', 1);
select * from address;

### Updates
update address set city = 'nyc' where id=1;
update user set surname = 'james', lastname='bond' where id>0 and id<10;

### Deletes
delete from address where id=1;
delete from user where id=1;

delete from address where id>0 and id<10;

# you get an error if you delete a users which still has addresses
# Cannot delete or update a parent row: a foreign key constraint fails (`fim`.`address`, CONSTRAINT `fk_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`))
# -> remove all addresses first
# -> change foreign key relationship to:  cascase delete
