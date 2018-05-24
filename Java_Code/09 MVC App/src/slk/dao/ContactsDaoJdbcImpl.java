package slk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import slk.entity.Contact;
import slk.util.DbUtil;

public class ContactsDaoJdbcImpl implements ContactsDao {

	@Override
	public void createContact(Contact contact) throws DaoException {
		String sql = "insert into contacts (id, name, email, phone, city, gender) values (?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, contact.getId());
			stmt.setString(2, contact.getName());
			stmt.setString(3, contact.getEmail());
			stmt.setString(4, contact.getPhone());
			stmt.setString(5, contact.getCity());
			stmt.setString(6, contact.getGender());
			stmt.execute();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.closeResources(conn, stmt, rs);
		}
	}

	@Override
	public Contact getCotnact(int id) throws DaoException {

		String sql = "select * from contacts where id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				Contact contact = resultSetToContact(rs);

				return contact;
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.closeResources(conn, stmt, rs);
		}

		return null;
	}

	@Override
	public void updateContact(Contact contact) throws DaoException {
		String sql = "update contacts set name=?, email=?, phone=?, city=?, gender=? where id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getPhone());
			stmt.setString(4, contact.getCity());
			stmt.setString(5, contact.getGender());
			stmt.setInt(6, contact.getId());

			stmt.execute();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.closeResources(conn, stmt, rs);
		}
	}

	@Override
	public void deleteContact(int id) throws DaoException {
		String sql = "delete from contacts where id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);

			int rowCount = stmt.executeUpdate();
			if (rowCount == 0) {
				throw new DaoException("Invalid id!");
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.closeResources(conn, stmt, rs);
		}
	}

	@Override
	public List<Contact> getAllContacts() throws DaoException {
		List<Contact> list = new ArrayList<>();
		String sql = "select * from contacts";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Contact contact = resultSetToContact(rs);
				list.add(contact);
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.closeResources(conn, stmt, rs);
		}

		return list;
	}

	@Override
	public List<Contact> getContactsByCity(String city) throws DaoException {

		List<Contact> list = new ArrayList<>();
		String sql = "select * from contacts where city like ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			// city = String.format("%%s%", city);
			city = "%" + city + "%";
			stmt.setString(1, city);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Contact contact = resultSetToContact(rs);
				list.add(contact);
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.closeResources(conn, stmt, rs);
		}

		return list;
	}

	@Override
	public List<Contact> search(String token) throws DaoException {
		List<Contact> list = new ArrayList<>();
		String sql = "select * from contacts where name like ? or email like ? or phone like ? or city like ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DbUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			// city = String.format("%%s%", city);
			token = "%" + token + "%";
			for (int i = 1; i <= 4; i++) {
				stmt.setString(i, token);
			}
			rs = stmt.executeQuery();

			while (rs.next()) {
				Contact contact = resultSetToContact(rs);
				list.add(contact);
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.closeResources(conn, stmt, rs);
		}

		return list;
	}

	private Contact resultSetToContact(ResultSet rs) throws SQLException {
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
