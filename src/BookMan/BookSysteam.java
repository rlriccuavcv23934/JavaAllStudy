package BookMan;

import BookManger.BookValue;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BookSysteam {
    private static List<BookValue> BOOK_VALUE_LIST;

    public static void main(String[] args) {
        System.out.println("正在加载图书管理系统...");
        BookLoad();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==============图书管理系统==============");
            System.out.println("1. 录入图书信息");
            System.out.println("2. 查询图书信息");
            System.out.println("3. 删除图书信息");
            System.out.println("4. 修改图书信息");
            System.out.println("5. 退出图书系统");
            System.out.println("=====================================");

            switch (sc.nextInt()) {
                case 1:
                    insert(sc);
                    break;
                case 2:
                    Book_List();
                    break;
                case 3:
                    BookDelete(sc);
                    break;
                case 4:
                    BookModify(sc);
                    break;
                case 5:
                    System.out.println("正在保存图书信息...");
                    BookSave();
                    System.out.println("感谢您的使用!!!");
                    sc.close();
                    return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void BookLoad() {
        File file = new File("BookData");
        if (file.exists()) {
            try (ObjectInputStream BookStream = new ObjectInputStream(new FileInputStream("BookData"))) {
                BOOK_VALUE_LIST = (List<BookValue>) BookStream.readObject();
                //对象的输出流： ObjectOutputStream
                //对象的输入流:  ObjectInputStream
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            BOOK_VALUE_LIST = new LinkedList<>();
        }
    }

    public static void BookModify(Scanner sc) {
        sc.nextLine();
        System.out.print("输入需要修改图书索引号: ");
        int index = sc.nextInt();
        sc.nextLine();//用于吸收sc中的换行符号(回车)
        while (index > BOOK_VALUE_LIST.size() - 1 || index < 0) {
            System.out.print("没有对应索引号, 请重新输入: ");
            index = sc.nextInt();
            sc.nextLine();//用于吸收sc中的换行符号(回车)
        }
        BookValue book = BOOK_VALUE_LIST.get(index);
        System.out.print("输入图书的名字: ");
        book.setTitle(sc.nextLine());

        System.out.print("输入图书的作者: ");
        book.setAuthor(sc.nextLine());

        System.out.print("输入图书的价格: ");
        book.setPrice(sc.nextDouble());

        System.out.println("图书修改成功");
    }

    public static void BookDelete(Scanner sc) {
        sc.nextLine();//用于吸收sc中的换行符号(回车)
        System.out.print("输入图书索引号: ");
        int index = sc.nextInt();
        sc.nextLine();//用于吸收sc中的换行符号(回车)
        while (index > BOOK_VALUE_LIST.size() || index < 0) {
            System.out.print("没有对应索引号, 请重新输入: ");
            index = sc.nextInt();
            sc.nextLine();//用于吸收sc中的换行符号(回车)
        }
        BOOK_VALUE_LIST.remove(index);
        System.out.println("图书删除成功");
    }

    public static void BookSave() {
        try (ObjectOutputStream BookStream = new ObjectOutputStream(new FileOutputStream("BookData"))) {
            BookStream.writeObject(BOOK_VALUE_LIST);
            //对象的输出流： ObjectOutputStream
            //对象的输入流:  ObjectInputStream
            BookStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insert(Scanner sc) {
        sc.nextLine();//用于吸收sc中的换行符号(回车)
        System.out.print("输入图书的名字: ");
        String title = sc.nextLine();
        System.out.print("输入图书的作者: ");
        String author = sc.nextLine();
        System.out.print("输入图书的价格: ");
        double price = sc.nextDouble();
        sc.nextLine();//用于吸收sc中的换行符号(回车)

        BookValue book = new BookValue(title, author, price);
        BOOK_VALUE_LIST.add(book);
        System.out.println("图书信息添加成功 " + book);
    }

    public static void Book_List() {
        for (int i = 0; i < BOOK_VALUE_LIST.size(); i++) {
            System.out.println(i + ". " + BOOK_VALUE_LIST.get(i));
        }
    }
}
