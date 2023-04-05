import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void menu(){
        System.out.println("1.ADD BOOK");
        System.out.println("2.SHOW ALL BOOK");
        System.out.println("3.SEARCH BOOK");
        System.out.println("4.UPDATE BOOK");
        System.out.println("5.DELETE BOOK");
        System.out.println("6.RETURN BOOK");
        System.out.println("7.EXIT");
    } // created Menu function

    public static void show_all_books(ArrayList <liberary> arr){
        int number=1;
        for (liberary items:arr) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println(number+"."+"BOOK ID: "+ items.id +
                               ", BOOK TITLE: " + items.title+
                               ", BOOK AUTHOR: " + items.author +
                               ", BOOK PUBLISH YEAR: " +items.pub_year);
            System.out.println("-------------------------------------------------------------------------");
             number++;
        }

    } // created show all books which takes array as parameter

   public static void search_book(ArrayList <liberary> arr){
        Scanner sc=new Scanner(System.in);
       System.out.println("enter the id to search");
       int Id=sc.nextInt();
       for (liberary items: arr) {
            if( items.id == Id){
                System.out.println(
                        "BOOK ID: "+ items.id +
                        ", BOOK TITLE: " + items.title+
                        ", BOOK AUTHOR: " + items.author +
                        ", BOOK PUBLISH YEAR: " +items.pub_year);
            }

            else {
                System.out.println("record not found!!!!!!!");
            }
          }
       }   // created search book which takes array as parameter

   public static void update_menu() {
       System.out.println("1.UPDATE ID");
       System.out.println("2.UPDATE TITLE");
       System.out.println("3.UPDATE AUTHOR");
       System.out.println("4.PUBLISH YEAR");
       System.out.println("5.GO BACK");

   }  // created a menu for update data  function

   public static void update_book(ArrayList <liberary> arr){
       Scanner sc=new Scanner(System.in);
       System.out.println("enter the id to update");
       int Id=sc.nextInt();

       for (liberary items:arr) {
           if (items.id ==Id){
               int j=0;
               int option;
               do {
                   update_menu();
                   System.out.println("enter the choice");
                   option= sc.nextInt();

                   switch (option){
                       case (1):
                           System.out.println("enter new id");
                           items.id= sc.nextInt();
                           System.out.println("id has been updated!!!");
                           break;

                       case (2):
                           System.out.println("enter new title");
                           items.title= sc.next();
                           System.out.println("title has been updated!!!");
                           break;

                       case (3):
                           System.out.println("enter new author");
                           items.author= sc.next();
                           System.out.println("author has been updated!!!");
                           break;

                       case (4):
                           System.out.println("enter new publish year");
                           items.pub_year= sc.next();
                           System.out.println("publish year has been updated!!!");
                       break;

                       case (5):
                           j++;
                   }
               }while (j==0);
           }
       }
   }  // created update book which takes array as parameter

    public static void delete_book(ArrayList <liberary> arr){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the id of book to delete!!");
        int Id = sc.nextInt();

        try{
            for (liberary items : arr) {
                if(items.id==Id){
                    arr.remove(items);
                    System.out.println("record has been deleted");

                }
                if (items.id != Id){
                    System.out.println("record not found!!!");
                }
            }
        }catch (Exception e){
            System.out.println("deleted!!!");
        }

    }





    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList <liberary> books =new ArrayList<>();


        int id;
        String title;
        String author;
        String pub_year;

        int option;
        do {
            menu();
            System.out.println("enter the option");
            option=sc.nextInt();

            switch (option){
                case (1):
                    System.out.println("enter the book id");
                    id= sc.nextInt();
                    System.out.println("enter the book title");
                    title=sc.next();
                    System.out.println("enter the book author");
                    author= sc.next();
                    System.out.println("enter the book publish year");
                    pub_year= sc.next();

                    books.add(new liberary(id, title, author,pub_year));
                    System.out.println("entries added successfully!!");
                    break;

                case (2):
                    show_all_books(books);  // calling  show_all_books function from above this function takes array as argument
                    break;

                case (3):
                    search_book(books);    // calling  search_book function from above this function takes array as argument
                    break;

                case (4):
                    update_book(books);  // calling  update book function from above this function takes array as argument
                    break;

                case (5):
                    delete_book(books);  // calling  delete book function from above this function takes array as argument
                    break;

                case (6):
                    Scanner sc1=new Scanner(System.in);
                    System.out.println("enter the book id for return");
                    id= sc.nextInt();
                    System.out.println("enter the book title  for return");
                    title=sc.next();
                    System.out.println("enter the book author  for return");
                    author= sc.next();
                    System.out.println("enter the book publish year  for return");
                    pub_year= sc.next();

                    books.add(new liberary(id, title, author,pub_year));
                    System.out.println("book has been returned");
                    break;

                case (7):
                    System.exit(0);
            }

        }while (option!=0);
    }
}