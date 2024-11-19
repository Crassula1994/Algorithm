package gold3.num15997;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 경기 결과에 대한 전문가의 예측, 각 국가가 다음 라운드에 진출할 확률을 저장할 각 배열 초기화
	static Match[] predictions = new Match[6];
	static double[] probabilities = new double[4];
	
	// 각 국가의 입력 순서를 저장할 Map 객체 nations 초기화
	static Map<String, Integer> nations = new HashMap<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// Match 클래스 정의
	static class Match {
		
		// 해당 경기의 두 국가, 전문가가 예측한 첫 국가의 승리, 무승부, 패배 확률을 저장할 각 변수 초기화
		String homeNation;
		String awayNation;
		double winRate;
		double drawRate;
		double loseRate;
		
		// 매개변수를 입력 받는 생성자 정의
		public Match(String homeNation, String awayNation, double winRate, double drawRate, double loseRate) {
			this.homeNation = homeNation;
			this.awayNation = awayNation;
			this.winRate = winRate;
			this.drawRate = drawRate;
			this.loseRate = loseRate;
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
		
		// for 반복문을 사용해 각 국가의 입력 순서를 nations에 저장
		for (int order = 0; order < 4; order++)
			nations.put(st.nextToken(), order);
		
		// for 반복문을 사용해 각 경기에 대한 전문가들의 예측을 순회
		for (int idx = 0; idx < predictions.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			/* nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 해당 경기의 두 국가,
			전문가가 예측한 첫 국가의 승리, 무승부, 패배 확률을 각 변수에 할당 */
			String homeNation = st.nextToken();
			String awayNation = st.nextToken();
			double winRate = Double.parseDouble(st.nextToken());
			double drawRate = Double.parseDouble(st.nextToken());
			double loseRate = Double.parseDouble(st.nextToken());
			
			// 입력 받은 전문가들의 예측을 배열 predictions에 저장
			predictions[idx] = new Match(homeNation, awayNation, winRate, drawRate, loseRate);
		}
		
		// caseChecker() 메서드를 호출해 각 국가가 다음 라운드에 진출할 확률을 갱신
		caseChecker(0, 1.0, new int[4]);
		
		// for 반복문을 사용해 각 국가가 다음 라운드에 진출할 확률을 출력
		for (double probability : probabilities)
			out.write(String.format("%.10f", probability) + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// caseChecker() 메서드 정의
	public static void caseChecker(int curMatch, double chance, int[] points) {
		
		// 모든 경기 결과를 확인한 경우
		if (curMatch == 6) {
			
			// chanceCalculator() 메서드를 호출해 각 국가가 다음 라운드에 진출할 확률을 갱신 후 메서드 종료
			chanceCalculator(chance, points);
			return;
		}
		
		// get() 메서드를 사용해 해당 경기의 각 국가의 입력 순서를 각 변수에 할당
		int homeOrder = nations.get(predictions[curMatch].homeNation);
		int awayOrder = nations.get(predictions[curMatch].awayNation);
		
		// 해당 경기의 첫 국가가 이길 수 있는 경우
		if (predictions[curMatch].winRate > 0) {
			
			// 첫 국가가 이긴 경우를 상정해 승점을 갱신
			points[homeOrder] += 3;
			
			// caseChecker() 메서드 재귀 호출
			caseChecker(curMatch + 1, chance * predictions[curMatch].winRate, points);
			
			// 승점 현황을 원상 복구
			points[homeOrder] -= 3;
		}
		
		// 해당 경기의 첫 국가가 비길 수 있는 경우
		if (predictions[curMatch].drawRate > 0) {
			
			// 두 국가가 비긴 경우를 상정해 승점을 갱신
			points[homeOrder] += 1;
			points[awayOrder] += 1;
			
			// caseChecker() 메서드 재귀 호출
			caseChecker(curMatch + 1, chance * predictions[curMatch].drawRate, points);
			
			// 승점 현황을 원상 복구
			points[homeOrder] -= 1;
			points[awayOrder] -= 1;
		}
		
		// 해당 경기의 첫 국가가 질 수 있는 경우
		if (predictions[curMatch].loseRate > 0) {
			
			// 첫 국가가 진 경우를 상정해 승점을 갱신
			points[awayOrder] += 3;
			
			// caseChecker() 메서드 재귀 호출
			caseChecker(curMatch + 1, chance * predictions[curMatch].loseRate, points);
			
			// 승점 현황을 원상 복구
			points[awayOrder] -= 3;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// chanceCalculator() 메서드 정의
	public static void chanceCalculator(double chance, int[] points) {
		
		// clone() 메서드를 사용해 각 국가의 승점을 오름차순으로 정렬할 배열 sortedPoints 초기화
		int[] sortedPoints = points.clone();
		
		// sort() 메서드를 사용해 각 국가의 승점을 오름차순으로 정렬
		Arrays.sort(sortedPoints);
		
		// 1위와 2위 국가의 승점 및 그때의 국가 수, 진출 확률을 저장할 각 변수 초기화
		int firstPoint = sortedPoints[3];
		int secondPoint = sortedPoints[2];
		int firstCount = 0;
		int secondCount = 0;
		double firstChance = 0;
		double secondChance = 0;
		
		// for 반복문을 사용해 각 국가의 승점을 순회
		for (int point : points) {
			
			// 1위 국가의 승점과 같은 경우 1위 국가의 수를 갱신
			if (point == firstPoint)
				firstCount++;
			
			// 2위 국가의 승점과 같은 경우 2위 국가의 수를 갱신
			if (point == secondPoint)
				secondCount++;
		}
		
		// 두 국가 이상이 1위인 경우 1위의 진출 확률을 갱신
		if (firstCount > 1) {
			firstChance = 2.0 / firstCount;
			
		// 한 국가만 1위인 경우 1위와 2위의 진출 확률을 갱신
		} else {
			firstChance = 1;
			secondChance = 1.0 / secondCount;
		}
		
		// for 반복문을 사용해 각 국가를 순회
		for (int idx = 0; idx < 4; idx++) {
			
			// 해당 국가가 1위인 경우 진출 확률을 갱신
			if (points[idx] == firstPoint) {
				probabilities[idx] += chance * firstChance;
				
			// 해당 국가가 2위인 경우 진출 확률을 갱신
			} else if (points[idx] == secondPoint) {
				probabilities[idx] += chance * secondChance;
			}
		}
	}
}