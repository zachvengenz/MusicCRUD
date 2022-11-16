package SWD4TN020.Music;


import org.slf4j.Logger;	
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import SWD4TN020.Music.domain.Album;
import SWD4TN020.Music.domain.AlbumRepository;
import SWD4TN020.Music.domain.Artist;
import SWD4TN020.Music.domain.ArtistRepository;
import SWD4TN020.Music.domain.RecordLabel;
import SWD4TN020.Music.domain.RecordLabelRepository;
import SWD4TN020.Music.domain.Track;
import SWD4TN020.Music.domain.TrackRepository;
import SWD4TN020.Music.domain.User;
import SWD4TN020.Music.domain.UserRepository;

@SpringBootApplication
public class MusicApplication {
	private static final Logger log = LoggerFactory.getLogger(MusicApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner musicDemo(AlbumRepository arepository, ArtistRepository artrepository, RecordLabelRepository rrepository, TrackRepository trepository, UserRepository urepository) {
		return (args) -> {
			
			User user1 = new User("user", "$2a$10$l/M7bGOBhl8lj8k.fkDNxuhhHLr1VsA4B2paUIlQ0nU9IQHN5b.iG", "USER");
			User user2 = new User("admin", "$2a$10$pjMxtPrL2VdKP5NcfvFpHey6MSlSbc3CeyC7Rua6MnNA.zJmk2mj.", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);  
			
			RecordLabel rl1 = new RecordLabel("Roadrunner Records");
			rrepository.save(rl1);
			RecordLabel rl2 = new RecordLabel("Warner Records");
			rrepository.save(rl2);
			RecordLabel rl3 = new RecordLabel("Capitol Records");
			rrepository.save(rl3);
			RecordLabel rl4 = new RecordLabel("Roswell Records");
			rrepository.save(rl4);
			RecordLabel rl5 = new RecordLabel("Spinefarm Records");
			rrepository.save(rl5);
			RecordLabel rl6 = new RecordLabel("Nuclear Blast Records");
			rrepository.save(rl6);
			RecordLabel rl7 = new RecordLabel("Warner Music Canada");
			rrepository.save(rl7);
			
			Artist art1 = new Artist("Avenged Sevenfold", "Heavy Metal", "USA", 1999);
			artrepository.save(art1);
			Artist art2 = new Artist("Gojira", "Death Metal", "France", 1996);
			artrepository.save(art2);
			Artist art3 = new Artist("Slipknot", "Alternative Metal", "USA", 1995);
			artrepository.save(art3);
			Artist art4 = new Artist("Foo Fighters", "Hard Rock", "USA", 1994);
			artrepository.save(art4);
			Artist art5 =  new Artist("Children of Bodom", "Melodic Death Metal", "Finland", 1993);
			artrepository.save(art5);
			Artist art6 = new Artist("In Flames", "Alternative Metal", "Sweden", 1990);
			artrepository.save(art6);
			Artist art7 = new Artist("As I Lay Dying", "Metalcore", "USA", 2000);
			artrepository.save(art7);
			Artist art8 = new Artist("Billy Talent", "Punk Rock", "Canada", 1993);
			artrepository.save(art8);
			
			Album a1 = new Album("Avenged Sevenfold", art1, 2007, rl2);
			arepository.save(a1);
			Album a2 = new Album("The Stage", art1, 2016, rl3);
			arepository.save(a2);
			Album a3 = new Album("Fortitude", art2, 2021, rl1);
			arepository.save(a3);
			Album a4 = new Album("Wasting Light", art4, 2011, rl4);
			arepository.save(a4);
			Album a5 = new Album("Hate Crew Deathroll", art5, 2003, rl5);
			arepository.save(a5);
			Album a6 = new Album("Iowa", art3, 2001, rl1);
			arepository.save(a6);
			Album a7 =  new Album("Come Clarity", art6, 2006, rl6);
			arepository.save(a7);
			Album a8 = new Album("Shaped By Fire", art7, 2019, rl6);
			arepository.save(a8);
			Album a9 = new Album("Afraid of Heights", art8, 2016, rl7);
			arepository.save(a9);
			
			// A7X self-titled album
			Track t1 = new Track("Critical Acclaim", a1);
			trepository.save(t1);
			Track t2 = new Track("Almost Easy", a1);
			trepository.save(t2);
			Track t3 = new Track("Scream", a1);
			trepository.save(t3);
			Track t4 = new Track("Afterlife", a1);
			trepository.save(t4);
			Track t5 = new Track("Gunslinger", a1);
			trepository.save(t5);
			Track t6 = new Track("Unbound (The Wild Ride)", a1);
			trepository.save(t6);
			Track t7 = new Track("Brompton Cocktail", a1);
			trepository.save(t7);
			Track t8 = new Track("Lost", a1);
			trepository.save(t8);
			Track t9 = new Track("A Little Piece of Heaven", a1);
			trepository.save(t9);
			Track t10 = new Track("Dear God", a1);
			trepository.save(t10);
			
			// A7X The Stage
			Track t11 = new Track("The Stage", a2);
			trepository.save(t11);
			Track t12 = new Track("Paradigm", a2);
			trepository.save(t12);
			Track t13 = new Track("Sunny Disposition", a2);
			trepository.save(t13);
			Track t14 = new Track("God Damn", a2);
			trepository.save(t14);
			Track t15 = new Track("Creating God", a2);
			trepository.save(t15);
			Track t16 = new Track("Angels", a2);
			trepository.save(t16);
			Track t17 = new Track("Simulation", a2);
			trepository.save(t17);
			Track t18 = new Track("Higher", a2);
			trepository.save(t18);
			Track t19 = new Track("Roman Sky", a2);
			trepository.save(t19);
			Track t20 = new Track("Fermi Paradox", a2);
			trepository.save(t20);
			Track t21 = new Track("Exist", a2);
			trepository.save(t21);
			
			// Gojira Fortitude
			Track t22 = new Track("Born For One Thing", a3);
			trepository.save(t22);
			Track t23 = new Track("Amazonia", a3);
			trepository.save(t23);
			Track t24 = new Track("Another World", a3);
			trepository.save(t24);
			Track t25 = new Track("Hold On", a3);
			trepository.save(t25);
			Track t26 = new Track("New Found", a3);
			trepository.save(t26);
			Track t27 = new Track("Fortitude", a3);
			trepository.save(t27);
			Track t28 = new Track("The Chant", a3);
			trepository.save(t28);
			Track t29 = new Track("Sphinx", a3);
			trepository.save(t29);
			Track t30 = new Track("Into The Storm", a3);
			trepository.save(t30);
			Track t31 = new Track("The Trails", a3);
			trepository.save(t31);
			Track t32 = new Track("Grind", a3);
			trepository.save(t32);
			
			// Foo Fighters Wasting Light
			Track t33 = new Track("Bridge Burning", a4);
			trepository.save(t33);
			Track t34 = new Track("Rope", a4);
			trepository.save(t34);
			Track t35 = new Track("Dear Rosemary", a4);
			trepository.save(t35);
			Track t36 = new Track("White Limo", a4);
			trepository.save(t36);
			Track t37 = new Track("Arlandria", a4);
			trepository.save(t37);
			Track t38 = new Track("These Days", a4);
			trepository.save(t38);
			Track t39 = new Track("Back & Forth", a4);
			trepository.save(t39);
			Track t40 = new Track("A Matter of Time", a4);
			trepository.save(t40);
			Track t41 = new Track("Miss the Misery", a4);
			trepository.save(t41);
			Track t42 = new Track("I Should Have Known", a4);
			trepository.save(t42);
			Track t43 = new Track("Walk", a4);
			trepository.save(t43);
			
			// COB Hate Crew Deathroll
			Track t44 = new Track("Needled 24/7", a5);
			trepository.save(t44);
			Track t45 = new Track("Sixpounder", a5);
			trepository.save(t45);
			Track t46 = new Track("Chokehold (Cocked 'n' Loaded)", a5);
			trepository.save(t46);
			Track t47 = new Track("Bodom Beach Terror", a5);
			trepository.save(t47);
			Track t48 = new Track("Angels Don't Kill", a5);
			trepository.save(t48);
			Track t49 = new Track("Triple Corpse Hammerblow", a5);
			trepository.save(t49);
			Track t50 = new Track("You're Better Off Dead", a5);
			trepository.save(t50);
			Track t51 = new Track("Lil' Bloodred Ridin' Hood", a5);
			trepository.save(t51);
			Track t52 = new Track("Hate Crew Deathroll", a5);
			trepository.save(t52);
			
			// Slipknot Iowa
			Track t53 = new Track("(515)", a6);
			trepository.save(t53);
			Track t54 = new Track("People = Shit", a6);
			trepository.save(t54);
			Track t55 = new Track("Disasterpiece", a6);
			trepository.save(t55);
			Track t56 = new Track("My Plague", a6);
			trepository.save(t56);
			Track t57 = new Track("Everything Ends", a6);
			trepository.save(t57);
			Track t58 = new Track("The Heretic Anthem", a6);
			trepository.save(t58);
			Track t59 = new Track("Gently", a6);
			trepository.save(t59);
			Track t60 = new Track("Left Behind", a6);
			trepository.save(t60);
			Track t61 = new Track("The Shape", a6);
			trepository.save(t61);
			Track t62 = new Track("I Am Hated", a6);
			trepository.save(t62);
			Track t63 = new Track("Skin Ticket", a6);
			trepository.save(t63);
			Track t64 = new Track("New Abortion", a6);
			trepository.save(t64);
			Track t65 = new Track("Metabolic", a6);
			trepository.save(t65);
			Track t66 = new Track("Iowa", a6);
			trepository.save(t66);
			
			// In Flames Come Clarity
			Track t67 = new Track("Take This Life", a7);
			trepository.save(t67);
			Track t68 = new Track("Leeches", a7);
			trepository.save(t68);
			Track t69 = new Track("Reflect the Storm", a7);
			trepository.save(t69);
			Track t70 = new Track("Dead End", a7);
			trepository.save(t70);
			Track t71 = new Track("Scream", a7);
			trepository.save(t71);
			Track t72 = new Track("Come Clarity", a7);
			trepository.save(t72);
			Track t73 = new Track("Vacuum", a7);
			trepository.save(t73);
			Track t74 = new Track("Pacing Death's Trail", a7);
			trepository.save(t74);
			Track t75 = new Track("Crawl Through Knives", a7);
			trepository.save(t75);
			Track t76 = new Track("Versus Terminus", a7);
			trepository.save(t76);
			Track t77 = new Track("Our Infinite Struggle", a7);
			trepository.save(t77);
			Track t78 = new Track("Vanishing Light", a7);
			trepository.save(t78);
			Track t79 = new Track("Your Bedtime Story Is Scaring Everyone", a7);
			trepository.save(t79);
			
			// AILD Shaped By Fire
			Track t80 = new Track("Burn To Emerge", a8);
			trepository.save(t80);
			Track t81 = new Track("Blinded", a8);
			trepository.save(t81);
			Track t82 = new Track("Shaped By Fire", a8);
			trepository.save(t82);
			Track t83 = new Track("Undertow", a8);
			trepository.save(t83);
			Track t84 = new Track("Torn Between", a8);
			trepository.save(t84);
			Track t85 = new Track("Gatekeeper", a8);
			trepository.save(t85);
			Track t86 = new Track("The Wreckage", a8);
			trepository.save(t86);
			Track t87 = new Track("My Own Grave", a8);
			trepository.save(t87);
			Track t88 = new Track("Take What's Left", a8);
			trepository.save(t88);
			Track t89 = new Track("Redefined", a8);
			trepository.save(t89);
			Track t90 = new Track("Only After We've Fallen", a8);
			trepository.save(t90);
			Track t91 = new Track("The Toll It Takes", a8);
			trepository.save(t91);
			
			// Billy Talent Afraid of Heights
			Track t92 = new Track("Big Red Gun", a9);
			trepository.save(t92);
			Track t93 = new Track("Afraid of Heights", a9);
			trepository.save(t93);
			Track t94 = new Track("Ghost Ship of Cannibal Rats", a9);
			trepository.save(t94);
			Track t95 = new Track("Louder Than the DJ", a9);
			trepository.save(t95);
			Track t96 = new Track("The Crutch", a9);
			trepository.save(t96);
			Track t97 = new Track("Rabbit Down the Hole", a9);
			trepository.save(t97);
			Track t98 = new Track("Time-Bomb Ticking Away", a9);
			trepository.save(t98);
			Track t99 = new Track("Leave Them All Behind", a9);
			trepository.save(t99);
			Track t100 = new Track("Horses & Chariots", a9);
			trepository.save(t100);
			Track t101 = new Track("This Is Our War", a9);
			trepository.save(t101);
			Track t102 = new Track("February Winds", a9);
			trepository.save(t102);
			Track t103 = new Track("Afraid of Heights (Reprise)", a9);
			trepository.save(t103);
			
			log.info("fetch record labels");
			for (RecordLabel recordLabel : rrepository.findAll()) {
				log.info(recordLabel.toString());
			}
			log.info("fetch artists");
			for (Artist artist : artrepository.findAll()) {
				log.info(artist.toString());
			}
			log.info("fetch albums");
			for (Album album : arepository.findAll()) {
				log.info(album.toString());
			}
			log.info("fetch tracks");
			for (Track track : trepository.findAll()) {
				log.info(track.toString());
			}
			
			/*
			
			Category category1 = new Category("Scifi/Fantasy");
			crepository.save(category1);
			Category category2 = new Category("Drama");
			crepository.save(category2);
			Category category3 = new Category("Mystery");
			crepository.save(category3);
			Category category4 = new Category("Biography");
			crepository.save(category4);
			
			log.info("save a few books");
			brepository.save(new Book("Seven Deadly Sins", "Corey Taylor", 2011, "9780306819278", 9.90, category4));
			brepository.save(new Book("America 51", "Corey Taylor", 2017, "9780306825446", 14.40, category3));
			brepository.save(new Book("You're Making Me Hate You", "Corey Taylor", 2015, "9780091960315", 13.80, category2));
			brepository.save(new Book("A Funny Thing Happened on the Way to Heaven", "Corey Taylor", 2013, "9780091949655", 11.20, category4));
			
			*/
			
		};
	}

}
