package co.com.cmdb.generales.infrastructure.primaryadapters.controller.apigateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class ApigatewayController {
	
	private List<Book> books = new ArrayList<>();
	
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		
		books.add(book);
		return book;
		
	}
	
	@GetMapping
	public List<Book> getBooks() {
		
		return books;
		
	}

}
