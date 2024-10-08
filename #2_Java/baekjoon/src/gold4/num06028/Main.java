package gold4.num06028;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 목초지와 연결된 소몰이 길의 정보를 저장할 배열 cowpaths 초기화
	static List<Cowpath>[] cowpaths;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Cowpath 클래스 정의
	static class Cowpath implements Comparable<Cowpath> {
		
		// 소몰이 길이 연결된 다른 목초지와 길이를 저장할 각 변수 초기화
		int endPasture;
		int length;
		
		// 매개변수를 입력 받는 생성자 정의
		public Cowpath(int endPasture, int length) {
			this.endPasture = endPasture;
			this.length = length;
		}
		
		// compareTo() 메서드 정의
		@Override
		public int compareTo(Cowpath anotherCowpath) {
			return this.length - anotherCowpath.length;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 목초지의 수, 소몰이 길의 수, 수소의 수를 각 변수에 할당
		int pastureNum = Integer.parseInt(st.nextToken());
		int cowpathNum = Integer.parseInt(st.nextToken());
		int bullNum = Integer.parseInt(st.nextToken());
		
		// 각 목초지와 연결된 소몰이 길의 정보를 저장할 배열 cowpaths 초기화
		cowpaths = new ArrayList[pastureNum + 1];
		
		// for 반복문을 사용해 각 목초지와 연결된 소몰이 길의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < cowpaths.length; idx++)
			cowpaths[idx] = new ArrayList<>();
		
		// while 반복문을 사용해 각 소몰이 길의 정보를 순회
		while (cowpathNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 소몰이 길이 연결된 각 목초지와 길이를 각 변수에 할당
			int startPasture = Integer.parseInt(st.nextToken());
			int endPasture = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 소몰이 길의 정보를 배열 cowpaths에 저장
			cowpaths[startPasture].add(new Cowpath(endPasture, length));
			cowpaths[endPasture].add(new Cowpath(startPasture, length));
		}
		
		// distCalculator() 메서드를 호출해 헛간으로부터 각 목초지까지의 최소 거리를 배열 minDists에 저장
		int[] minDists = distCalculator(1, pastureNum);
		
		// while 반복문을 사용해 각 수소의 정보를 순회
		while (bullNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수소와 암소의 위치를 각 변수에 할당
			int bullPasture = Integer.parseInt(st.nextToken());
			int cowPasture = Integer.parseInt(st.nextToken());
			
			// 수소가 암소에게 가기 위한 가장 짧은 거리를 계산해 변수 minDist에 할당
			int minDist = minDists[bullPasture] + minDists[cowPasture];
			
			// write() 메서드를 사용해 수소가 암소에게 가기 위한 가장 짧은 거리를 출력
			out.write(minDist + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// distCalculator() 메서드 정의
	public static int[] distCalculator(int startPasture, int pastureNum) {
		
		// 헛간으로부터 다른 목초지까지 가장 짧은 거리를 저장할 배열 minDists 초기화
		int[] minDists = new int[pastureNum + 1];
		
		// 다음에 이동할 소몰이 길을 저장할 PriorityQueue 객체 moveList 초기화
		PriorityQueue<Cowpath> moveList = new PriorityQueue<>();
		
		// fill() 메서드를 사용해 시작 목초지로부터 다른 목초지까지 가장 짧은 거리를 초기화
		Arrays.fill(minDists, Integer.MAX_VALUE);
		
		// offer() 메서드를 사용해 수소가 위치한 목초지를 moveList에 추가 및 가장 짧은 거리를 갱신
		moveList.offer(new Cowpath(startPasture, 0));
		minDists[startPasture] = 0;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 이동할 소몰이 길를 변수 curCowpath에 할당
			Cowpath curCowpath = moveList.poll();
			
			// 현재 이동할 소몰이 길의 거리가 해당 목초지까지의 최단 거리보다 먼 경우 다음 소몰이 길을 순회
			if (curCowpath.length > minDists[curCowpath.endPasture])
				continue;
			
			// for 반복문을 사용해 현재 목초지와 연결된 각 소몰이 길을 순회
			for (Cowpath nextCowpath : cowpaths[curCowpath.endPasture]) {
				
				// 다음에 이동할 목초지와 그 이동 거리를 각 변수에 할당
				int nextPasture = nextCowpath.endPasture;
				int nextLength = curCowpath.length + nextCowpath.length;
				
				// 더 짧은 거리로 이동할 수 있는 경우 해당 목초지까지의 거리 갱신 및 moveList에 추가
				if (nextLength < minDists[nextPasture]) {
					minDists[nextPasture] = nextLength;
					moveList.offer(new Cowpath(nextPasture, minDists[nextPasture]));
				}
			}
		}
		
		// 헛간으로부터 다른 목초지까지 가장 짧은 거리를 저장한 배열을 반환
		return minDists;
	}
}