/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package texteditor;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    private StringBuilder currentText;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

  
    public TextEditor() {
        currentText = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

 
    public void show() {
        System.out.println("\nIsi Teks Saat Ini:");
        System.out.println(currentText.length() == 0 ? "(Kosong)" : currentText.toString());
    }

   
    public void write(String text) {
        
        undoStack.push(currentText.toString());
        redoStack.clear(); 
        currentText.append(text);
        System.out.println("Teks berhasil ditambahkan.");
    }

    
    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText.toString());
            currentText = new StringBuilder(undoStack.pop());
            System.out.println("Undo berhasil.");
        } else {
            System.out.println("Tidak ada tindakan yang bisa di-undo.");
        }
    }

    
    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText.toString());
            currentText = new StringBuilder(redoStack.pop());
            System.out.println("Redo berhasil.");
        } else {
            System.out.println("Tidak ada tindakan yang bisa di-redo.");
        }
    }

    
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Teks (Show)");
            System.out.println("2. Tambah Teks (Write)");
            System.out.println("3. Undo");
            System.out.println("4. Redo");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    editor.show();
                    break;

                case 2:
                    System.out.print("Masukkan teks yang ingin ditambahkan: ");
                    String text = scanner.nextLine();
                    editor.write(text);
                    break;

                case 3:
                    editor.undo();
                    break;

                case 4:
                    editor.redo();
                    break;

                case 5:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

