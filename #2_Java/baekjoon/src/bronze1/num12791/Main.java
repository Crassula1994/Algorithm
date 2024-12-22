package bronze1.num12791;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 데이빗 보위의 앨범 이름과 발매연도를 저장할 각 배열 초기화
	static String[] albumNames = {
			"DavidBowie", "SpaceOddity", "TheManWhoSoldTheWorld", "HunkyDory", "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars",
			"AladdinSane", "PinUps", "DiamondDogs", "YoungAmericans", "StationToStation",
			"Low", "Heroes", "Lodger", "ScaryMonstersAndSuperCreeps", "LetsDance",
			"Tonight", "NeverLetMeDown", "BlackTieWhiteNoise", "1.Outside", "Earthling",
			"Hours", "Heathen", "Reality", "TheNextDay", "BlackStar"
	};
	static int[] years = {
			1967, 1969, 1970, 1971, 1972, 1973, 1973, 1974, 1975, 1976,
			1977, 1977, 1979, 1980, 1983, 1984, 1987, 1993, 1995, 1997,
			1999, 2002, 2003, 2013, 2016
	};
	
	// 데이빗 보위의 앨범을 저장할 Map 객체 albums 초기화
	static Map<String, Integer> albums = new LinkedHashMap<>();
	
	// for 반복문을 사용해 데이빗 보위의 앨범 정보를 albums에 추가
	static {
		for (int idx = 0; idx < 25; idx++)
			albums.put(albumNames[idx], years[idx]);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 질의의 수를 변수 queryNum에 할당
		int queryNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 질의를 순회
		while (queryNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 질의의 시작 연도와 끝 연도를 각 변수에 할당
			int startYear = Integer.parseInt(st.nextToken());
			int endYear = Integer.parseInt(st.nextToken());
			
			// 해당 질의를 만족하는 데이빗 보위의 앨범 수를 저장할 변수 count 초기화
			int count = 0;
			
			// 해당 조건에 해당하는 데이빗 보위의 앨범을 저장할 StringBuilder 객체 sb 초기화
			StringBuilder sb = new StringBuilder();
			
			// for 반복문을 사용해 각 앨범을 순회
			for (String albumName : albums.keySet()) {
				
				// get() 메서드를 사용해 해당 앨범의 발매 연도를 변수 year에 할당
				int year = albums.get(albumName);
				
				// 해당 앨범이 질의를 만족하지 않는 경우 다음 앨범을 순회
				if (year < startYear || year > endYear)
					continue;
				
				// 해당 질의를 만족하는 데이빗 보위의 앨범 수를 갱신
				count++;
				
				// append() 메서드를 사용해 sb에 해당 앨범의 이름과 발매 연도를 추가
				sb.append(year).append(" ").append(albumName).append("\n");
			}
			
			// toString() 및 write() 메서드를 사용해 해당 질의를 만족하는 데이빗 보위의 앨범 수와 그 앨범 정보를 출력
			out.write(count + "\n" + sb.toString());
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}