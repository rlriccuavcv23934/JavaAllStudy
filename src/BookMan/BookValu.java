package BookMan;

//import lombok.Getter;

import java.io.Serializable;
//@Getter
public class BookValu implements Serializable {//添加序列化,就是保存
    // 序列化的过程，就是一个“freeze”的过程，
    // 它将一个对象freeze（冷冻）住，然后进行存储，
    // 等到再次需要的时候，再将这个对象de-freeze就可以立即使用。
    private String title;
    private String author;
    private double price;

    public BookValu(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookValue{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
