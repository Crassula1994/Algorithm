package silver1.num01495;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 곡의 개수, 시작 볼륨, 최대 볼륨을 각 변수에 할당
		int songNum = Integer.parseInt(st.nextToken());
		int startVolume = Integer.parseInt(st.nextToken());
		int maxVolume = Integer.parseInt(st.nextToken());
		
		// 마지막 곡의 최대 볼륨을 나타낼 변수 lastVolume 초기화
		int lastVolume = -1;
		
		// 각 곡의 볼륨 차이, 각 볼륨별 연주한 곡의 개수를 저장할 각 배열 초기화
		int[] differences = new int[songNum + 1];
		Integer[] songCounts = new Integer[maxVolume + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 곡의 볼륨 차이를 배열 differences에 저장
		for (int idx = 1; idx <= songNum; idx++)
			differences[idx] = Integer.parseInt(st.nextToken());
		
		// 시작 볼륨에서 연주한 곡의 개수를 갱신
		songCounts[startVolume] = 0;
		
		// for 반복문을 사용해 각 곡을 차례로 순회
		for (int song = 1; song <= songNum; song++) {
			
			// 현재 곡에서 가능한 볼륨을 저장할 Set 객체 possibleVolumes 초기화
			Set<Integer> possibleVolumes = new HashSet<>();
			
			// for 반복문을 사용해 다음에 확인할 볼륨을 차례로 순회
			for (int volume = 0; volume <= maxVolume; volume++) {
				
				// 이전에 연주한 곡의 볼륨인 경우
				if (songCounts[volume] != null && songCounts[volume] == song - 1) {
					
					// 음량을 키우는 경우와 음량을 줄이는 경우를 계산해 각 변수에 할당
					int highVolume = volume + differences[song];
					int lowVolume = volume - differences[song];
					
					// 음량을 키울 수 있는 경우 possibleVolumes에 추가
					if (highVolume >= 0 && highVolume <= maxVolume)
						possibleVolumes.add(highVolume);
					
					// 음량을 줄일 수 있는 경우 possibleVolumes에 추가
					if (lowVolume >= 0 && lowVolume <= maxVolume)
						possibleVolumes.add(lowVolume);
				}
			}
			
			// for 반복문을 사용해 현재 곡에서 가능한 볼륨을 갱신
			for (int volume : possibleVolumes)
				songCounts[volume] = song;
		}
		
		// for 반복문을 사용해 각 볼륨을 순회
		for (int volume = 0; volume <= maxVolume; volume++) {
			
			// 마지막 곡까지 연주한 볼륨일 경우 마지막 곡의 최대 볼륨을 갱신
			if (songCounts[volume] != null && songCounts[volume] == songNum)
				lastVolume = Math.max(volume, lastVolume);
		}
		
		// valueOf() 및 write() 메서드를 사용해 마지막 곡의 최대 볼륨을 출력
		out.write(String.valueOf(lastVolume));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}