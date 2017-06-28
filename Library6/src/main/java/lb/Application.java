package lb;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lb.entity.Books;
import lb.entity.College;
import lb.entity.Subjects;
import lb.repo.SubjectsRepository;
import lb.repo.CollegeRepository;
import lb.repo.BooksRepository;

@SpringBootApplication
public class Application {
	@Autowired
	private CollegeRepository collegeRepo;
	
	@Autowired
	private SubjectsRepository SubjectsRepo;
	
	@Autowired
	private BooksRepository booksRepo;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    

    
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			College college1 = new College(1L,"sk","生命科学学院");
			College college2 = new College(2L,"jk","计算机科学学院");
			College college3 = new College(3L,"fx","法学学院");
			collegeRepo.save(college1);	
			collegeRepo.save(college2);
			collegeRepo.save(college3);
			
			Subjects sub1 =  new Subjects(1L,"dwx","动物学");
			sub1.setCollege(college1);
			SubjectsRepo.save(sub1);
			
			Subjects sub2 =  new Subjects(2L,"zwx","植物学");
			sub2.setCollege(college1);
			SubjectsRepo.save(sub2);
			
			Subjects sub3 =  new Subjects(3L,"rjgc","软件工程");
			sub3.setCollege(college2);
			SubjectsRepo.save(sub3);
			
			Subjects sub4 =  new Subjects(4L,"xa","信息安全");
			sub4.setCollege(college2);
			SubjectsRepo.save(sub4);
			
			Subjects sub5 =  new Subjects(5L,"fx","法学");
			sub5.setCollege(college3);
			SubjectsRepo.save(sub5);
			
			Subjects sub6 =  new Subjects(6L,"gax","公安学");
			sub6.setCollege(college3);
			SubjectsRepo.save(sub6);
			
			Date publicationday = Calendar.getInstance().getTime();
			
			
			
			Books bok1 = new Books(1L,"s00001","sk","dwx",
					"动物行为与进化生物学",new Date("1998/08/01"));
			Books bok2 = new Books(2L,"s00002","sk","zwx",
					"植物保育遗传与育种",new Date("1994/02/01"));
			Books bok3 = new Books(3L,"s00003","sk","zwx",
					"森林植物分子生物技术",new Date("20004/11/21"));
			Books bok4 = new Books(4L,"s00004","jk","rjgc",
					"个体软件过程",new Date("2006/04/16"));
			Books bok5 = new Books(5L,"s00005","jk","xa",
					"密码学",new Date("1997/06/05"));
			Books bok6 = new Books(6L,"s00006","jk","rjgc",
					"软件项目管理",new Date("1985/01/12"));
			Books bok7 = new Books(7L,"s00007","fx","fx",
					"民事法",new Date("1996/07/12"));
			Books bok8 = new Books(8L,"s00008","fx","fx",
					"刑法",new Date("1999/10/11"));
			Books bok9 = new Books(9L,"s00009","fx","fx",
					"知识产权法",new Date("1996/04/11"));
			Books bok10 = new Books(10L,"s00010","jk","rjgc",
					"c语言程序综合设计",new Date("1995/11/01"));
			Books bok11 = new Books(11L,"s00011","jk","xa",
					"计算机网络安全",new Date("1995/11/21"));
			Books bok12 = new Books(12L,"s00012","jk","xa",
					"无线网络安全攻防实战进阶",new Date("1995/01/29"));
			Books bok13 = new Books(13L,"s00013","jk","rjgc",
					"数据结构与算法分析",new Date("1995/11/11"));
			Books bok14 = new Books(14L,"s00014","fx","gax",
					"治安学",new Date("1995/11/12"));
			Books bok15 = new Books(15L,"s00015","fx","gax",
					"侦查学",new Date("1995/10/11"));
			
//			
			
			bok1.setSubjects(sub1);
			bok2.setSubjects(sub2);
			bok3.setSubjects(sub2);
			bok4.setSubjects(sub3);
			bok5.setSubjects(sub4);
			bok6.setSubjects(sub3);
			bok7.setSubjects(sub5);
			bok8.setSubjects(sub5);
			bok9.setSubjects(sub5);
			bok10.setSubjects(sub3);
			bok11.setSubjects(sub4);
			bok12.setSubjects(sub4);
			bok13.setSubjects(sub3);
			bok14.setSubjects(sub6);
			bok15.setSubjects(sub6);
			
//
		    booksRepo.save(bok1);
			booksRepo.save(bok2);
			booksRepo.save(bok3);
			booksRepo.save(bok4);
			booksRepo.save(bok5);
			booksRepo.save(bok6);
			booksRepo.save(bok7);
			booksRepo.save(bok8);
			booksRepo.save(bok9);
			booksRepo.save(bok10);
			booksRepo.save(bok11);
			booksRepo.save(bok12);
			booksRepo.save(bok13);
			booksRepo.save(bok14);
			booksRepo.save(bok15);
			
		};
    }

}
