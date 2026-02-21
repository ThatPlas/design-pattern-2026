package fr.fges.menu.options;

import fr.fges.menu.handlers.MenuHandler;

import java.time.LocalDate;

public interface MenuOption {

    String title();
    MenuHandler getHandler();
    boolean isAvailable(LocalDate date);

}
