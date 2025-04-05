import java.util.*;
class Movie{
    String title;
    int AvailableSeats;
    public Movie(String title,int AvailableSeats){
        this.title=title;
        this.AvailableSeats=AvailableSeats;
    }
    public void displayMovie(){
        System.out.println(title +" | AvailableSeats :"+AvailableSeats);
    }
    public boolean bookSeats(int seats){
        if(AvailableSeats>=seats){
            AvailableSeats-=seats;
            return true;
        }
        else{
            return false;
        }
    }
}
class User{
    String name;
    public User(String name){
        this.name=name;
    }
}
class Booking{
    Movie movie;
    User user;
    int bookedSeats;
    public Booking(Movie movie,User user,int bookedSeats){
        this.movie=movie;
        this.user=user;
        this.bookedSeats=bookedSeats;
    }
    public void BookingDetails(){
        System.out.println("Booking Successful!!");
        System.out.println("User : "+user.name);
        System.out.println("Movie :  "+movie.title);
        System.out.println("Seats Booked : "+bookedSeats);
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        //Movie List
        ArrayList<Movie> m=new ArrayList<>();
        m.add(new Movie("Kalki 2898AD",10));
        m.add(new Movie("RRR",15));
        m.add(new Movie("Pushpa : The Rise ",8));
        //User Resignation
        System.out.println("Enter your name :");
        String userName=s.nextLine();
        User user=new User(userName);
        //Display Movies
        for(int i=0;i<m.size();i++){
            System.out.print((i+1)+".");
            m.get(i).displayMovie();
        }
        //Select Movie
        System.out.println("Select a Movie(Enter number) :");
        int MovieChoice=s.nextInt();
        if(MovieChoice<1 || MovieChoice>m.size()){
            System.out.println("Invalid choice!");
            return;
        }
        Movie selectedMovie=m.get(MovieChoice-1);
        System.out.println("Enter number of Seats:");
        int seats=s.nextInt();
        if(selectedMovie.bookSeats(seats)){
            Booking booking=new Booking(selectedMovie,user,seats);
            booking.BookingDetails();
        }
        else{
            System.out.println("Not enough seats available");
        }
    }
}
