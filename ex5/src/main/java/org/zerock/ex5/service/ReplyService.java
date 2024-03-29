package org.zerock.ex5.service;

import org.zerock.ex5.dto.ReplyDTO;
import org.zerock.ex5.entity.Board;
import org.zerock.ex5.entity.Reply;

import java.util.List;

public interface ReplyService{
	Long register(ReplyDTO replyDto);

	List<ReplyDTO> getList(Long bno);

	void modify(ReplyDTO replyDTO);

	void remove(Long rno);

	default Reply dtoToEntity(ReplyDTO dto){
		Board board=Board.builder()
				.bno(dto.getBno())
				.build();

		Reply reply=Reply.builder()
				.rno(dto.getRno())
				.text(dto.getText())
				.replyer(dto.getReplyer())
				.board(board)
				.build();
		return reply;
	}

	default ReplyDTO entityToDto(Reply reply){
		ReplyDTO replyDTO=ReplyDTO.builder()
				.rno(reply.getRno())
				.text(reply.getText())
				.replyer(reply.getReplyer())
				.regDate(reply.getRegDate())
				.modDate(reply.getModDate())
				.build();
		return replyDTO;
	}
}
