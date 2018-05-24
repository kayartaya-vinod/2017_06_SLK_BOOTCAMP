package slk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import slk.entity.Contact;

public class ContactsDaoSpringImpl implements ContactsDao {

	@Autowired
	private JdbcTemplate template;

	public ContactsDaoSpringImpl() {
	}

	@Override
	public void createContact(Contact contact) throws DaoException {
		try {
			template.update(
					"insert into contacts (id, name, email, phone, city, gender) values (?,?,?,?,?,?)", 
					contact.getId(), 
					contact.getName(), 
					contact.getEmail(), 
					contact.getPhone(),
					contact.getCity(), 
					contact.getGender());
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Contact getContact(int id) throws DaoException {
		return template.queryForObject(
				"select * from contacts where id = ?", new ContactRowMapper(), id);
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		try {
			template.update(
					"update contacts set name=?, email=?, phone=?, city=?, gender=? where id=?", 
					contact.getName(), 
					contact.getEmail(), 
					contact.getPhone(),
					contact.getCity(), 
					contact.getGender(),
					contact.getId());
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}
	@Override
	public void deleteContact(int id) throws DaoException {
		try {
			int rc = template.update("delete from contacts where id=?", id);
			if(rc==0){
				throw new DaoException("Invalid id");
			}
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public List<Contact> getAllContacts() throws DaoException {
		return template.query("select * from contacts", new ContactRowMapper());
	}

	@Override
	public List<Contact> getContactsByCity(String city) throws DaoException {
		return template.query("select * from contacts where city like ?", 
				new ContactRowMapper(), "%" + city +"%");
	}

	@Override
	public List<Contact> search(String token) throws DaoException {
		token = "%"+token+"%";
		return template.query(
				"select * from contacts where name like ? or email like ? or phone like ? or city like ?", 
				new ContactRowMapper(), token, token, token, token);
	}
	
	class ContactRowMapper implements RowMapper<Contact>{
		@Override
		public Contact mapRow(ResultSet rs, int index) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getInt("id"));
			contact.setName(rs.getString("name"));
			contact.setEmail(rs.getString("email"));
			contact.setPhone(rs.getString("phone"));
			contact.setCity(rs.getString("city"));
			contact.setGender(rs.getString("gender"));
			return contact;
		}
	}

}
