package com.ssu.archive.PL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssu.archive.entity.*;
import com.ssu.archive.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helpers {
    PatentLogic logicPatent;
    BookLogic logicBook;
    ArticleLogic logicArticle;
    NewspaperLogic logicNewspaper;
    AuthorLogic logicAuthor;
    private final ObjectMapper mapper = new ObjectMapper();

    public Helpers(PatentLogic logicPatent, BookLogic logicBook, ArticleLogic logicArticle, NewspaperLogic logicNewspaper,AuthorLogic logicAuthor) {
        this.logicPatent = logicPatent;
        this.logicBook = logicBook;
        this.logicArticle = logicArticle;
        this.logicNewspaper = logicNewspaper;
        this.logicAuthor = logicAuthor;
    }
    public void Add(String typeClass, AbstractPrintedProducts entities) {
        switch (typeClass) {
            case "Book":
                logicBook.add((Book)entities);
                break;
            case "Patent":
                logicPatent.add((Patent)entities);
                break;
            case "Newspaper":
                logicNewspaper.add((Newspaper)entities);
                break;
            case "Article":
                logicArticle.add((Article)entities);
                break;
            default:
                break;
        }
    }

    public void Update(String typeClass, AbstractPrintedProducts entities) {
        switch (typeClass) {
            case "Book":
                logicBook.update((Book)entities);
                break;
            case "Patent":
                logicPatent.update((Patent)entities);
                break;
            case "Newspaper":
                logicNewspaper.update((Newspaper)entities);
                break;
            case "Article":
                logicArticle.update((Article)entities);
                break;
            default:
                break;
        }
    }

    public void Delete(String typeClass, AbstractPrintedProducts entities) {
        switch (typeClass) {
            case "Book":
                logicBook.delete((Book)entities);
                break;
            case "Patent":
                logicPatent.delete((Patent)entities);
                break;
            case "Newspaper":
                logicNewspaper.delete((Newspaper)entities);
                break;
            case "Article":
                logicArticle.delete((Article)entities);
                break;
            default:
                break;
        }
    }

    public List<? extends AbstractPrintedProducts> GetAll(String typeClass) {
        switch (typeClass) {
            case "Book":
                return logicBook.getAll();
            case "Patent":
                return logicPatent.getAll();
            case "Newspaper":
                return logicNewspaper.getAll();
            case "Article":
                return logicArticle.getAll();
            default:
                return null;
        }
    }

    public AbstractPrintedProducts GetById(String typeClass, Integer id) throws Exception {
        switch (typeClass) {
            case "Book":
                return logicBook.getById(id);
            case "Patent":
                return logicPatent.getById(id);
            case "Newspaper":
                return logicNewspaper.getById(id);
            case "Article":
                return logicArticle.getById(id);
            default:
                System.out.println("This is type absent");
                return null;
        }
    }

    public AbstractPrintedProducts setUpEntity(String typeClass, boolean update) throws Exception {
        Scanner in = new Scanner(System.in);
        Integer id;
        List<Author> author;
        switch (typeClass) {
            case "Book":
                Book book;
                if(update) {
                    var books = logicBook.getAll();
                    for (var item :books) {
                        String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(item);
                        System.out.println(jsonResult);
                    }

                    id = inputInteger();

                    book = logicBook.getById(id);
                }
                else
                    book = new Book();

                System.out.println("Enter title book: ");
                book.setTitle(in.nextLine());
                System.out.println("Enter PublishingHouse book: ");
                book.setPublishingHouse(in.nextLine());
                System.out.println("Enter NumberOfPages book: ");
                id = inputInteger();

                if(id == null) {
                    System.out.println("Not correctly input, set default 0");
                    book.setNumberOfPages(0);
                }
                else
                    book.setNumberOfPages(id);

                System.out.println("Enter City book: ");
                book.setCity(in.nextLine());
                System.out.println("Enter ISBN book: ");
                book.setISBN(in.nextLine());

                System.out.println("Enter authors book: ");
                author = new ArrayList<>();
                author.add(setUpAuthors());
                book.setAuthor(author);

                if(book.getAuthor().size() == 0) {
                    book.setAuthor(author);
                    System.out.println("you not added no one authors");
                }
                System.out.println("=========================");
                System.out.println("You added Book");
                System.out.println("=========================");
                return book;
            case "Patent":
                Patent patent;
                if(update) {
                    id = inputInteger();

                    patent = logicPatent.getById(id);
                }
                else
                    patent = new Patent();

                System.out.println("Enter title patent: ");
                patent.setTitle(in.nextLine());
                System.out.println("Enter number of pages  patent: ");
                id = inputInteger();
                if(id == null) {
                    System.out.println("Not correctly input, set default 0");
                    patent.setNumberOfPages(0);
                }
                else
                    patent.setNumberOfPages(id);

                System.out.println("Enter country patent: ");
                patent.setCountry(in.nextLine());
                System.out.println("Enter registration number patent: ");
                id = inputInteger();
                if(id == null){
                    System.out.println("Not correctly input, set default 0");
                    patent.setRegistrationNumber(0);
                }
                else
                    patent.setNumberOfPages(id);

                System.out.println("Enter authors patent: ");
                author = new ArrayList<>();

                author.add(setUpAuthors());
                patent.setAuthor(author);

                if(patent.getAuthor().size() == 0) {
                    patent.setAuthor(author);
                    System.out.println("you not added no one authors");
                }
                System.out.println("=========================");
                System.out.println("You added Patent");
                System.out.println("=========================");
                return patent;
            case "Article":
                Article article;
                if(update) {
                    id = inputInteger();
                    article = logicArticle.getById(id);
                }
                else
                    article = new Article();

                System.out.println("Enter title article: ");
                article.setTitle(in.nextLine());
                System.out.println("Enter publishing house  article: ");
                article.setPublishingHouse(in.nextLine());
                System.out.println("Enter number of pages  article: ");
                id = inputInteger();

                if(id == null) {
                    System.out.println("Not correctly input, set default 0");
                    article.setNumberOfPages(0);
                }
                else
                    article.setNumberOfPages(id);
                System.out.println("=========================");
                System.out.println("You added Article");
                System.out.println("=========================");
                return article;
            case "Newspaper":
                Newspaper newspaper;
                if(update) {
                    id = inputInteger();

                    newspaper = logicNewspaper.getById(id);
                }
                else
                    newspaper = new Newspaper();

                System.out.println("Enter title newspaper: ");
                newspaper.setTitle(in.nextLine());
                System.out.println("Enter PublishingHouse book: ");
                newspaper.setPublishingHouse(in.nextLine());
                System.out.println("Enter number of pages  newspaper: ");
                id = inputInteger();
                if(id == null) {
                    System.out.println("Not correctly input, set default 0");
                    newspaper.setNumberOfPages(0);
                }
                else
                    newspaper.setNumberOfPages(id);

                System.out.println("Enter city newspaper: ");
                newspaper.setCity(in.nextLine());
                System.out.println("Enter ISSN newspaper: ");
                newspaper.setISSN(in.nextLine());

                System.out.println("=========================");
                System.out.println("You added Newspaper");
                System.out.println("=========================");
                return newspaper;
            default:
                return null;
        }
    }

    public Author setUpAuthors() throws Exception {
        Scanner in = new Scanner(System.in);
        var listAuthors = logicAuthor.getAll();

        for (var item: listAuthors) {
            String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(item);
            System.out.println(jsonResult);
        }
        while(true) {
            System.out.println("Enter id author: ");
            var id = inputInteger();
            try{
                return logicAuthor.getById(id);
            }
            catch (Exception ex) {
                System.out.println("Record with such id not found");
                return null;
            }

        }
    }

    public AbstractPrintedProducts selectEntity(String typeEntity) throws Exception {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Enter id product which wanted to delete: ");
            String idStr = in.nextLine();
            var id = parseIntOrNull(idStr);
            AbstractPrintedProducts temp = null;

            if(id != null)  {
                switch (typeEntity) {
                    case "Book" -> temp = logicBook.getById(id);
                    case "Newspaper" -> temp = logicNewspaper.getById(id);
                    case "Article" -> temp = logicArticle.getById(id);
                    case "Patent" -> temp = logicPatent.getById(id);
                    default -> {
                        System.out.println("This type not define");
                        return null;
                    }
                }
            }
            while(true) {
                System.out.println("confirm yourself select? y/n");

                String select = in.nextLine();

                if (select.equals("y") || select.equals("Y")){
                    return temp;
                }
                else if (select.equals("n") || select.equals("N")){
                    return null;
                }
                else{
                    System.out.println("TRY AGAIN");
                }
            }
        }
    }

    public Integer parseIntOrNull(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Integer inputInteger() {
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Enter number or something id: ");
            String idStr = in.nextLine();
            var id = parseIntOrNull(idStr);

            while(true) {
                System.out.println("confirm yourself select? y/n");

                String select = in.nextLine();

                if (select.equals("y") || select.equals("Y")){
                    return id;
                }
                else if (select.equals("n") || select.equals("N")){
                    return null;
                }
                else{
                    System.out.println("TRY AGAIN");
                }
            }
        }
    }
}
