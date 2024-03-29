package org.zerock.ex7.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.ex7.dto.NoteDTO;
import org.zerock.ex7.service.NoteService;

import java.util.List;

@Log
@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
	private final NoteService noteService;

	@PostMapping(value="")
	public ResponseEntity<Long> register(@RequestBody NoteDTO noteDTO){
		log.info("note register..........");
		Long num=noteService.register(noteDTO);
		return new ResponseEntity<>(num, HttpStatus.OK);
	}

	@GetMapping(value="/{num}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NoteDTO> read(@PathVariable("num")Long num){
		log.info("note read.........."+num);
		return new ResponseEntity<>(noteService.get(num),HttpStatus.OK);
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NoteDTO>> getList(String email) {
		log.info("note read all..........");
		return new ResponseEntity<>(noteService.getAllWithWriter(email), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{num}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> remove(@PathVariable("num") Long num) {
		log.info("note delete.........."+num);
		noteService.remove(num);
		return new ResponseEntity<>("removed", HttpStatus.OK);
	}

	@PutMapping(value = "/{num}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> modify(@RequestBody NoteDTO dto) {
		log.info("note modify.........."+dto.getNum());
		noteService.modify(dto);
		return new ResponseEntity<>("modified", HttpStatus.OK);
	}
}
