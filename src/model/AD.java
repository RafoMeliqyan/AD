package model;

import java.util.Date;

public class AD {
    private String title;
    private String text;
    private double price;
    Date date = new Date();
    private String category;
    private String author;

    public AD(String title, String text, double price, Date date, String category, String author) {
        this.title = title;
        this.text = text;
        this.price = price;
        this.date = date;
        this.category = category;
        this.author = author;
    }

    public AD() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AD ad = (AD) o;

        if (Double.compare(ad.price, price) != 0) return false;
        if (title != null ? !title.equals(ad.title) : ad.title != null) return false;
        if (text != null ? !text.equals(ad.text) : ad.text != null) return false;
        if (date != null ? !date.equals(ad.date) : ad.date != null) return false;
        if (category != null ? !category.equals(ad.category) : ad.category != null) return false;
        return author != null ? author.equals(ad.author) : ad.author == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AD{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", author=" + author +
                '}';
    }
}
