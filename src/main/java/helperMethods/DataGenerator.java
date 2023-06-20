package helperMethods;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

@SuppressWarnings("deprecation")
public class DataGenerator {

	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 10;

	public int getRandomNumber() {
		int randomInt;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	public String generateRandomString() {

		StringBuffer StrBuffer = new StringBuffer();

		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			StrBuffer.append(ch);
		}
		return StrBuffer.toString();
	}

	public String generateName() {
		return "Test" + generateRandomString();
	}

	public String generateDummyQuestion() {
		return "What is " + generateRandomString();
	}

	public String generateRandomPhoneNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	public String generateEmailAddress() {
		return "Test" + generateRandomString() + "@yopmail.com";
	}

	public int generateLowerPercentage() {
		Random randomGenerator = new Random();
		int num = randomGenerator.nextInt(30) + 1;
		return num;
	}

	public int generateUpperPercentage() {
		Random randomGenerator = new Random();
		int abc = 10 + randomGenerator.nextInt(90);
		return abc;
	}

	public String generatePortal() {
		StringBuffer StrBuffer = new StringBuffer();

		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomNumber();
			char ch = CHAR_LIST.charAt(number);
			StrBuffer.append(ch);
		}
		return StrBuffer.toString().toLowerCase();
	}
}
