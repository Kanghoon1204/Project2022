package com.example.dao;


import com.example.bean.BoardVO;
import com.example.bean.MessageVO;
import com.example.util.JDBCUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	static Connection conn = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;

	private final String BOARD_INSERT = "insert into CookBOARD (category, title, writer, content, anonymous, photo) values (?,?,?,?,?,?)";
	private final String BOARD_UPDATE = "update CookBOARD set category=?, title=?, writer=?, content=? , photo=?, anonymous=? where seq=?";
	private final String BOARD_DELETE = "delete from CookBOARD  where seq=?";
	private static final String BOARD_GET = "select * from CookBOARD  where seq=?";
	private final String BOARD_LIST = "select * from CookBOARD order by seq desc";

	private final String Message_INSERT = "insert into Message (content_message,cnt_message) values (?,?)";
	private final String Message_DELETE = "delete from Message  where seq=?";
	private static final String Message_GET = "select * from Message  where seq=?";
	private final String Message_LIST = "select * from Message order by seq desc";

	public static String getPhotoFilename(int sid) {
		String filename = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1,sid);
			rs = stmt.executeQuery();
			if (rs.next())
			{
				filename = rs.getString("photo");

			}
			rs.close();
		}catch (Exception e){
			e.printStackTrace();;
		}
		System.out.println("JDBC로 getPhotoFilename() 기능 처리");
		return filename;
	}

	public int insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getCategory());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getWriter());
			stmt.setString(4, vo.getContent());
			stmt.setBoolean(5, vo.getAnonymous());
			stmt.setString(6, vo.getPhoto());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getCategory());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getWriter());
			stmt.setString(4, vo.getContent());
			stmt.setString(5, vo.getPhoto());
			stmt.setBoolean(6, vo.getAnonymous());
			stmt.setInt(7, vo.getSeq());
			
			
			System.out.println(vo.getCategory() + "-" + vo.getTitle() + "-" + vo.getWriter() + "-" + vo.getContent() + "-" + vo.getSeq());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public BoardVO getBoard(int seq) {
		BoardVO one = new BoardVO();
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSeq(rs.getInt("seq"));
				one.setCategory(rs.getString("category"));
				one.setTitle(rs.getString("title"));
				one.setWriter(rs.getString("writer"));
				one.setContent(rs.getString("content"));
				one.setCnt(rs.getInt("cnt"));
				one.setAnonymous(rs.getBoolean("anonymous"));
				one.setHave_Img(rs.getBoolean("have_Img"));
				one.setPhoto(rs.getString("photo"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO one = new BoardVO();
				one.setSeq(rs.getInt("seq"));
				one.setCategory(rs.getString("category"));
				one.setTitle(rs.getString("title"));
				one.setWriter(rs.getString("writer"));
				one.setContent(rs.getString("content"));
				one.setRegdate(rs.getDate("regdate"));
				one.setModify(rs.getDate("modify"));
				one.setAnonymous(rs.getBoolean("anonymous"));
				one.setHave_Img(rs.getBoolean("have_Img"));
				one.setCnt(rs.getInt("cnt"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}

	public int insertMessage(MessageVO vo) {
		System.out.println("===>  디버깅");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(Message_INSERT);
			stmt.setString(1, vo.getContent_message());
			stmt.setInt(2, vo.getCnt_message());
			stmt.executeUpdate();
			System.out.println(vo.getContent_message() + "-" + vo.getCnt_message());
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	// 글 삭제
	public void deleteMessage(MessageVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(Message_DELETE);
			stmt.setInt(1, vo.getSeq_message());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MessageVO getMessage(int seq) {
		MessageVO one = new MessageVO();
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(Message_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSeq_message(rs.getInt("seq"));
				one.setContent_message(rs.getString("content_message"));
				one.setCnt_message(rs.getInt("cnt_message"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}

	public List<MessageVO> getMessageList(int input){
		List<MessageVO> list = new ArrayList<MessageVO>();
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(Message_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				MessageVO one = new MessageVO();
				if (rs.getInt("cnt_message") == input)
				{
					one.setSeq_message(rs.getInt("seq"));
					one.setContent_message(rs.getString("content_message"));
					one.setRegdate_message(rs.getDate("regdate"));
					one.setCnt_message(rs.getInt("cnt_message"));
					list.add(one);
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
