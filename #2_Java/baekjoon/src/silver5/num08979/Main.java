package silver5.num08979;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Country 클래스 정의
	public static class Country implements Comparable<Country> {
		
		// 국가명, 국가의 금메달, 은메달, 동메달 수를 나타낼 각 변수 초기화
		int name;
		int gold;
		int silver;
		int bronze;
		
		// 인자를 입력 받는 생성자 정의
		public Country(int name, int gold, int silver, int bronze) {
			this.name = name;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Country c) {
			return (gold == c.gold) ? (silver == c.silver) ? c.bronze - bronze : c.silver - silver : c.gold - gold;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 국가의 수와 등수를 알고 싶은 국가를 각 변수에 할당
		int countryNum = Integer.parseInt(st.nextToken());
		int targetCountry = Integer.parseInt(st.nextToken());
		
		// 각 국가의 순서를 저장할 PriorityQueue 객체 rankMaker 초기화
		PriorityQueue<Country> rankMaker = new PriorityQueue<>();
		
		// for 반복문을 사용하여 각 국가의 메달 정보를 모두 순회
		for (int c = 0; c < countryNum; c++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 국가의 정보를 각 변수에 할당
			int name = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			
			// offer() 메서드를 사용해 해당 국가의 정보를 rankMaker에 추가
			rankMaker.offer(new Country(name, gold, silver, bronze));
		}
		
		// 현재의 등수와 확인한 국가의 수, 이전의 국가 정보를 저장할 각 변수 초기화
		int rank = 0;
		int count = 0;
		Country prevCountry = new Country(0, -1, -1, -1);
		
		// while 반복문을 사용해 rankMaker가 빌 때까지 순회
		while (!rankMaker.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 국가를 변수 curCountry에 할당
			Country curCountry = rankMaker.poll();
			
			// 이전 국가와 모든 메달 수가 같은 경우 확인한 국가의 수만 갱신
			if (prevCountry.gold == curCountry.gold && prevCountry.silver == curCountry.silver
					&& prevCountry.bronze == curCountry.bronze) {
				count++;
				
			// 이전 국가와 메달 수가 다른 경우 확인한 국가의 수와 등수 갱신
			} else {
				count++;
				rank = count;
			}

			// 현재 국가의 정보를 prevCountry에 저장
			prevCountry = curCountry;
			
			// 현재 국가가 목표 국가인 경우 반복문 탈출
			if (curCountry.name == targetCountry)
				break;
		}
		
		// valueOf() 및 write() 메서드를 사용해 등수를 알고 싶은 국가의 등수를 출력
		out.write(String.valueOf(rank));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}