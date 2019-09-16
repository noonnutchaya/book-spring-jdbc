package th.ku.bookstore;

public class Book {
    private int id;
    private int price ;
    private String name;

    public Book(String name, int price, int id ) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "th.ku.bookstore.Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price + '}';
    }

}
