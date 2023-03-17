package com.manish;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookOrder{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int BookId;
String BookName;
int BookPrice;
String AuthorName;
String LibraryName;
public BookOrder() {
	
}
public int getBookId() {
	return BookId;
}
public void setBookId(int bookId) {
	this.BookId = bookId;
}
public String getBookName() {
	return BookName;
}
public void setBookName(String bookName) {
	this.BookName = bookName;
}
public int getBookPrice() {
	return BookPrice;
}
public void setBookPrice(int bookPrice) {
	this.BookPrice = bookPrice;
}
public String getAuthorName() {
	return AuthorName;
}
public void setAuthorName(String authorName) {
	this.AuthorName = authorName;
}
public String getLibraryName() {
	return LibraryName;
}
public void setLibraryName(String libraryName) {
	this.LibraryName = libraryName;
}
public Book(int bookId, String bookName, int bookPrice, String authorName, String libraryName) {
	super();
	this.BookId = bookId;
	this.BookName = bookName;
	this.BookPrice = bookPrice;
	this.AuthorName = authorName;
	this.LibraryName = libraryName;
}
}
