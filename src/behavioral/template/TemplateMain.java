package behavioral.template;

import java.util.Arrays;

public class TemplateMain {

	public static void main(String[] args) {
		JobSearch javaJobSearch = new JavaJobSearch();
		JobSearch qaJobSearch = new QAJobSearch();
		for (JobSearch jobSearch : Arrays.asList(javaJobSearch, qaJobSearch)) {
			jobSearch.startSearch();
			System.out.println();
		}
	}

}

abstract class JobSearch {

	abstract void doStepOne();

	abstract void doStepTwo();
	
	void startSearch() {
		doStepOne();
		doStepTwo();
	}

}

class JavaJobSearch extends JobSearch {

	@Override
	void doStepOne() {
		System.out.println("Searching job sites with tag <Java>...");
	}

	@Override
	void doStepTwo() {
		System.out.println("Attending English classes...");
	}
	
}

class QAJobSearch extends JobSearch {

	@Override
	void doStepOne() {
		System.out.println("Searching job sites with tag <QA>...");
	}

	@Override
	void doStepTwo() {
		System.out.println("Exercising English yourself...");
	}
	
}