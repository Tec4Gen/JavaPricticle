package com.ssu.archive.PL;

import com.ssu.archive.dao.*;
import com.ssu.archive.service.*;

public class ConsoleLogic {

    public ConsoleLogic() {
        var logicUser = new UserLogic(new UserDao());
        var logicPatent = new PatentLogic(new PatentDao());
        var logicBook = new BookLogic(new BookDao());
        var logicArticle = new ArticleLogic(new ArticleDao());
        var logicNewspaper = new NewspaperLogic(new NewspaperDao());
        var logicAuthor = new AuthorLogic(new AuthorDao());
    }

    public void Run() {

    }
}
