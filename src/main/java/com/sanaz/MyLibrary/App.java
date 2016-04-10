package com.sanaz.MyLibrary;

import java.util.ArrayList;

import model.Author;
import model.Book;
import model.BookCopies;
import model.BookLoans;
import model.Borrower;
import model.LibraryBranch;
import model.Publisher;
import service.AuthorDTO;
import service.BookCopiesDTO;
import service.BookDTO;
import service.BookLoansDTO;
import service.BorrowerDTO;
import service.LibraryBranchDTO;
import service.PublisherDTO;

public class App {
	public static void main(String[] args) {
		
		/**************AUTHOR*******************/
		AuthorDTO authorDto = new AuthorDTO();
		ArrayList<Author> authors = authorDto.getAuthors();

		for (Author a : authors) {
			System.out.println("Author ID : " + a.getAuthorId());
			System.out.println("Author Name : " + a.getAuthorName());
		}
		/**************BOOK COPIES**************/
		BookCopiesDTO bookCopiesDto = new BookCopiesDTO();
		ArrayList<BookCopies> bookCopies = bookCopiesDto.getBookCopies();

		for (BookCopies bc : bookCopies) {
			System.out.println("Book ID: " + bc.getBookId());
			System.out.println("Branch ID: " + bc.getBranchId());
			System.out.println("Nomber of copies : " + bc.getNoOfCopies());
		}
		/****************BOOK*******************/
		BookDTO bookDto = new BookDTO();
		ArrayList<Book> books = bookDto.getBooks();
		
		for(Book b : books){
			System.out.println("Book ID : " + b.getBookId());
			System.out.println("Title : " + b.getTitle());
			System.out.println("Author ID : " + b.getAuthor().getAuthorId());
			System.out.println("Author Name : " + b.getAuthor().getAuthorName());

			System.out.println("Publisher ID : " + b.getPubId());
		}
		/****************BORROWER****************/
		BorrowerDTO borrowerDto = new BorrowerDTO();
		ArrayList<Borrower> borrowers = borrowerDto.getBorrowers();
		
		for(Borrower bo : borrowers){
			System.out.println("Card Number : " + bo.getCardNo());
			System.out.println("Borrower Name : " + bo.getName());
			System.out.println("Boroower address : " + bo.getAddress());
			System.out.println("Borrower phone : " + bo.getPhone());
		}
		/******************BOOK LOANS*************/
		BookLoansDTO bookLoansDto = new BookLoansDTO();
		ArrayList<BookLoans> bookLoans = bookLoansDto.getBookLoans();
		
		for(BookLoans bl : bookLoans){
			System.out.println("Book ID : " + bl.getBookId());
			System.out.println("Branch ID : " + bl.getBranchId());
			System.out.println("Card number : " + bl.getCardNo());
			System.out.println("date out " + bl.getDateOut());
			System.out.println("Due date " + bl.getDueDate());
		}
		/******************LIBRARY BRANCH**********/
		LibraryBranchDTO libraryBranchDto = new LibraryBranchDTO();
		ArrayList<LibraryBranch> libraryBranches = libraryBranchDto.getBranches();
		
		for(LibraryBranch lb : libraryBranches){
			System.out.println("Branch ID : " + lb.getBranchId());
			System.out.println("Branch name : " + lb.getBranchName());
			System.out.println("Branch address : " + lb.getBranchAddress());
		}
		/******************PUBLISHER***************/
		PublisherDTO publisherDto = new PublisherDTO();
		ArrayList<Publisher> publishers = publisherDto.getPublishers();
		
		for(Publisher p : publishers){
			System.out.println("Publisher ID : " + p.getPubliserId());
			System.out.println("Publisher name : " + p.getPublisherName());
			System.out.println("Publisher address : " + p.getPublisherAddress());
			System.out.println("Publisher phone : " + p.getPublisherPhone());
		}
	}
}
