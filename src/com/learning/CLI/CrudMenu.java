package com.learning.CLI;

import com.learning.services.CrudService;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public abstract class CrudMenu<T> {
    private final String label;
    private final CrudService<T> service;

    protected CrudMenu(String label, CrudService<T> service) {
        this.label = label;
        this.service = service;
    }

    public String getLabel() {
        return label;
    }

    public void run(Scanner input) {
        while (true) {
            System.out.println("\n=== " + label + " ===");
            System.out.println("1. Save (create or replace by ID)");
            System.out.println("2. List all");
            System.out.println("3. Find by ID");
            System.out.println("4. Delete by ID");
            System.out.println("0. Back");
            int choice = CliInput.readChoice(input, "Choose an action: ", 0, 4);
            if (choice == 0) {
                return;
            }
            if (choice == 1) {
                save(input);
            } else if (choice == 2) {
                listAll();
            } else if (choice == 3) {
                findById(input);
            } else {
                deleteById(input);
            }
        }
    }

    protected abstract T readEntity(Scanner input);

    protected abstract String describe(T entity);

    private void save(Scanner input) {
        T entity = readEntity(input);
        try {
            service.save(entity);
            System.out.println("Saved: " + describe(entity));
        } catch (IllegalArgumentException exception) {
            System.out.println("Could not save: " + exception.getMessage());
        }
    }

    private void listAll() {
        List<T> entities = service.findAll();
        if (entities.isEmpty()) {
            System.out.println("No " + label.toLowerCase() + " found.");
            return;
        }
        for (T entity : entities) {
            System.out.println(describe(entity));
        }
    }

    private void findById(Scanner input) {
        int id = CliInput.readInt(input, "ID: ");
        Optional<T> entity = service.findById(id);
        if (entity.isPresent()) {
            System.out.println(describe(entity.get()));
        } else {
            System.out.println("No " + label.toLowerCase() + " found with ID " + id + ".");
        }
    }

    private void deleteById(Scanner input) {
        int id = CliInput.readInt(input, "ID to delete: ");
        if (service.deleteById(id)) {
            System.out.println("Deleted ID " + id + ".");
        } else {
            System.out.println("No " + label.toLowerCase() + " found with ID " + id + ".");
        }
    }
}
