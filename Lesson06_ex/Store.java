public class Store {
    private int money;

    public void purchase(Book book){
        System.out.println("「" + book.getTitle() + "」" + "を仕入れました");
        money -= book.getPrice()*0.8;
    }

    public void sell(Book book){
        System.out.println("「" + book.getTitle() + "」" + "を売りました");
        money += book.getPrice();
    }

    public int getMoney(){
        System.out.println("今のStoreの所持金は" + this.money + "円です");
        return this.money;
    }

    public Store(int money){
        this.money = money;
    }

}