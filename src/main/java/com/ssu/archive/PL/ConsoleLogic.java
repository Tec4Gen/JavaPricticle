package com.ssu.archive.PL;

import com.ssu.archive.dao.*;
import com.ssu.archive.entity.*;
import com.ssu.archive.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class ConsoleLogic {
    private final ObjectMapper mapper = new ObjectMapper();

    UserLogic logicUser;
    PatentLogic logicPatent;
    BookLogic logicBook;
    ArticleLogic logicArticle;
    NewspaperLogic logicNewspaper;
    AuthorLogic logicAuthor;
    Helpers helpers;

    public ConsoleLogic() {
        this.logicUser = new UserLogic(new UserDao());
        this.logicPatent = new PatentLogic(new PatentDao());
        this.logicBook = new BookLogic(new BookDao());
        this.logicArticle = new ArticleLogic(new ArticleDao());
        this.logicNewspaper = new NewspaperLogic(new NewspaperDao());
        this.logicAuthor = new AuthorLogic(new AuthorDao());
        this.helpers = new Helpers(logicPatent,logicBook,logicArticle,logicNewspaper, logicAuthor);
    }

    public void Run() throws Exception {
        Scanner in = new Scanner(System.in);

        boolean flagAuthorization = false;

        while(!flagAuthorization) {
            System.out.println("Please select action");
            System.out.println("1) I want sign up");
            System.out.println("2) I want sign in");

            String actionStr = in.nextLine();
            var action = helpers.parseIntOrNull(actionStr);

            if(action != null) {
                switch (action) {
                    case 1 -> {
                        var user = new UserAccount();
                        System.out.println("Input Login: ");
                        user.setLogin(in.nextLine());
                        System.out.println("Input Password: ");
                        user.setHashPassword(in.nextLine());
                        System.out.println("Input FirstName: ");
                        user.setFirstName(in.nextLine());
                        System.out.println("Input LastName: ");
                        user.setLastName(in.nextLine());
                        if (registration(user)) {
                            System.out.println("registration successful");
                            flagAuthorization = true;
                        } else {
                            System.out.println("registration failed");
                            System.out.println("======================");
                            System.out.println("Please TRY AGAIN");
                            System.out.println("======================");
                        }
                        break;
                    }
                    case 2 -> {
                        System.out.println("Input Login: ");
                        String loginAuth = in.nextLine();
                        System.out.println("Input Password: ");
                        String passwordAuth = in.nextLine();
                        if (authorization(loginAuth, passwordAuth)) {
                            System.out.println("login successful");
                            flagAuthorization = true;
                        } else {
                            System.out.println("login failed");
                            System.out.println("======================");
                            System.out.println("Please TRY AGAIN");
                            System.out.println("======================");
                        }
                    }
                }
            }
        }

        while(true) {
            System.out.println("====Select entity====");
            System.out.println("1) Book");
            System.out.println("2) Patent");
            System.out.println("3) Newspaper");
            System.out.println("4) Article");
            System.out.println("5) Exit");


            var actionStr = in.nextLine();
            var action = helpers.parseIntOrNull(actionStr);

            switch (action) {
                case 1:
                    actionMenu("Book");
                    break;
                case 2:
                    actionMenu("Patent");
                    break;
                case 3:
                    actionMenu("Newspaper");
                    break;
                case 4:
                    actionMenu("Article");
                    break;
                case 5:
                    return;
            }
        }
    }

    private void actionMenu(String typeClass) throws Exception {
        AbstractPrintedProducts setUpTemp;
        Integer id;
        System.out.println("====Select action====");
        System.out.println(String.format("1) Add %s", typeClass));
        System.out.println(String.format("2) Update %s", typeClass));
        System.out.println(String.format("3) Delete %s", typeClass));
        System.out.println(String.format("4) GetAll %s", typeClass));
        System.out.println(String.format("5) GetById %s", typeClass));
        System.out.println(String.format("6) Back"));

        Scanner in = new Scanner(System.in);

        var actionStr = in.nextLine();
        var action = helpers.parseIntOrNull(actionStr);

        switch (action) {
            case 1:
                setUpTemp = helpers.setUpEntity(typeClass, false);
                helpers.Add(typeClass,setUpTemp);
                break;
            case 2:
                setUpTemp = helpers.setUpEntity(typeClass, true);
                helpers.Update(typeClass,setUpTemp);
                break;
            case 3:
                setUpTemp = helpers.selectEntity(typeClass);
                helpers.Delete(typeClass,setUpTemp);
                break;
            case 4:
                var tempAll = helpers.GetAll(typeClass);
                for (var item: tempAll) {
                    String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(item);
                    System.out.println(jsonResult);
                }

                break;
            case 5:
                id = helpers.inputInteger();
                AbstractPrintedProducts temp = null;
                try {
                    temp = helpers.GetById(typeClass, id);
                }
                catch (Exception ex) {
                    System.out.println("Record with such id not found");
                }

                System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(temp));
                break;
            case 6:
                return;
        }
    }

    private boolean authorization(String login, String password) {
        return logicUser.authorization(login, password);
    }

    private boolean registration(UserAccount userAccount) {
        return logicUser.registration(userAccount);
    }
}
