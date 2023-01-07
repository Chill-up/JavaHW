
import java.util.ArrayList;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Infrastructure infrastructure = new Infrastructure();
    System.out.println("\n=========================\n");
    System.out.println("В базе данных находятся следующие фильмы:\n");
    System.out.println(infrastructure.getAllInfo(1));
    System.out.println(infrastructure.getAllInfo(2));
    System.out.println(infrastructure.getAllInfo(3));
    System.out.println(infrastructure.getAllInfo(4));
    System.out.println(infrastructure.getAllInfo(5));
    System.out.println("\n=========================\n");

    infrastructure.searchCinema();
  }
}

class Infrastructure {
  public Infrastructure() {
    init();
  }

  Db db;

  public Db getDb() {
    return db;
  }

  public String getAllInfo(int idCinema) {
    Cinema c = db.films.get(idCinema - 1);

    return String.format("%d %s %s %s",
        c.id,
        c.name,
        db.genres.get(c.genre - 1).name,
        db.prod.get(c.filmProd - 1).titleName);
  }

  Db init() {
    db = new Db();
    Cinema c1 = new Cinema(1, "Тьма", 1, 1);
    Cinema c2 = new Cinema(2, "Свет", 1, 2);
    Cinema c3 = new Cinema(3, "Особенности национальной рыбалки", 3, 4);
    Cinema c4 = new Cinema(4, "Человек паук", 3, 3);
    Cinema c5 = new Cinema(5, "Властелин рыб", 2, 3);

    db.films.add(c1);
    db.films.add(c2);
    db.films.add(c3);
    db.films.add(c4);
    db.films.add(c5);

    db.genres.add(new Genre(1, "Ужасы"));
    db.genres.add(new Genre(2, "Драма"));
    db.genres.add(new Genre(3, "Комедия"));
    FilmProducerFactory pf = new FilmProducerFactory();
    db.addFilmProducer(pf.getFilmProducer("Ленфильм"));
    db.addFilmProducer(pf.getFilmProducer("Марвел"));
    db.addFilmProducer(pf.getFilmProducer("Мосфильм"));
    db.addFilmProducer(pf.getFilmProducer("DC"));

    return db;
  }

  public void searchCinema() {
    boolean check = true;
    Scanner sc = new Scanner(System.in, "Cp866");
    String text = "";
    while (check) {
      System.out
          .println("Для поиска фильма введите название фильма или часть названия, для завершения поиска введите 0");
      text = sc.nextLine();
      if (text.equals("0"))
        check = false;
      else {
        ArrayList<Cinema> movies = new ArrayList<>();
        for (Cinema cinema : db.films) {
          if (cinema.name.toLowerCase().indexOf(text.toLowerCase()) != -1) {
            movies.add(cinema);
          }
        }
        if (movies.size() == 0)
          System.out.println("\nНи одного совпадения не найдено");
        else {
          System.out.println("\nНайдены следующие совпадения: ");
          for (Cinema cinema : movies) {
            System.out.println(getAllInfo(cinema.id));
          }
        }
      }
    }
  }
}

class Db {
  ArrayList<Cinema> films = new ArrayList<>();
  ArrayList<FilmProducer> prod = new ArrayList<>();
  ArrayList<Genre> genres = new ArrayList<>();

  public void addFilmProducer(FilmProducer producer) {
    prod.add(producer);
  }
}

class Cinema {
  int id;
  int filmProd;
  String name;
  int genre;

  public Cinema(int id, String name, int genre, int filmProd) {
    this.id = id;
    this.filmProd = filmProd;
    this.name = name;
    this.genre = genre;
  }
}

class FilmProducer {
  int id;
  String titleName;
}

class Genre {
  int id;
  String name;

  public Genre(int id, String name) {
    this.id = id;
    this.name = name;
  }
}

class FilmProducerFactory {
  int count = 1;

  public FilmProducer getFilmProducer(String name) {
    FilmProducer fp = new FilmProducer();
    fp.id = count++;
    fp.titleName = name;
    return fp;
  }
}