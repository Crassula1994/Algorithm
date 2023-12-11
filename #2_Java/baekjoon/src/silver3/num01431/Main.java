package silver3.num01431;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {
	
	// SerialNumber 클래스 정의
	public static class SerialNumber implements Comparable<SerialNumber> {
		
		// 시리얼 번호의 문자열, 길이, 자리수의 합을 저장할 각 변수 초기화
		String string;
		int length;
		int sum;
		
		// 인자를 입력 받는 생성자 정의
		public SerialNumber(String string) {
			
			// 시리얼 번호의 문자열을 변수 string에 저장
			this.string = string;
			
			// length() 메서드를 사용해 시리얼 번호의 길이를 변수 length에 저장
			this.length = string.length();
			
			// 자리수의 합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// for 반복문을 사용해 각 시리얼 번호의 자리를 순회
			for (int idx = 0; idx < string.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 자리를 변수 character에 할당
				char character = string.charAt(idx);
				
				// 해당 자리가 숫자인 경우 자리수의 합을 갱신
				if (character < 65)
					sum += character - '0';
			}
			
			// 시리얼 번호의 자리수의 합을 변수 sum에 저장
			this.sum = sum;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(SerialNumber anotherSerial) {
			
			// 길이가 같은 경우
			if (length == anotherSerial.length) {
				
				// 자리수의 합이 같은 경우 사전순으로 정렬
				if (sum == anotherSerial.sum)
					return string.compareTo(anotherSerial.string);
				
				// 자리수의 합이 적은 순서대로 정렬
				return sum - anotherSerial.sum;
			}
			
			// 길이가 짧은 순서대로 정렬
			return length - anotherSerial.length;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 기타의 개수를 변수 guitarNum에 할당
		int guitarNum = Integer.parseInt(in.readLine());
		
		// 기타의 시리얼 번호를 정렬할 PriorityQueue 객체 sorter 초기화
		PriorityQueue<SerialNumber> sorter = new PriorityQueue<>();
		
		// for 반복문을 사용해 입력 받은 시리얼 번호를 sorter에 저장
		for (int guitar = 0; guitar < guitarNum; guitar++)
			sorter.offer(new SerialNumber(in.readLine()));
		
		// while 반복문을 사용해 시리얼 번호를 정렬한 결과를 출력
		while (!sorter.isEmpty())
			out.write(sorter.poll().string + "\n");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}