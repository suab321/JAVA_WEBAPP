package com.example.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
	
	@Modifying
	@Transactional
	@Query(value="select * from chat where from_user=?1 and to_user=?2", nativeQuery=true)
	public List<Chat> getMessages(int from, int to);
}
