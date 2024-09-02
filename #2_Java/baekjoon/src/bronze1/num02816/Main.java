package bronze1.num02816;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 채널의 수를 변수 channelNum에 할당
		int channelNum = Integer.parseInt(in.readLine());
		
		// KBS1과 KBS2 채널의 초기 채널 번호를 저장할 각 변수 초기화
		int chKBS1 = 0;
		int chKBS2 = 0;
		
		// 상근이가 눌러야 하는 버튼을 순서대로 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 입력 받은 채널을 배열 channels에 저장
		for (int channel = 1; channel <= channelNum; channel++) {
			
			// readLine() 메서드를 사용해 해당 채널의 이름을 변수 name에 할당
			String name = in.readLine();
			
			// 해당 채널이 KBS1인 경우 초기 채널 번호를 갱신
			if (name.equals("KBS1")) {
				chKBS1 = channel;
				
			// 해당 채널이 KBS2인 경우 초기 채널 번호를 갱신
			} else if (name.equals("KBS2")) {
				chKBS2 = channel;
			}
		}
		
		// KBS1 채널이 첫 번째에 위치하지 않는 경우
		if (chKBS1 != 1) {
			
			// for 반복문을 사용해 KBS1 채널의 위치로 보내는 1번 버튼을 sb에 추가
			for (int count = 0; count < chKBS1 - 1; count++)
				sb.append(1);
			
			// for 반복문을 사용해 첫 번째 위치로 KBS1 채널을 올려 보내는 4번 버튼을 sb에 추가
			for (int count = 0; count < chKBS1 - 1; count++)
				sb.append(4);
			
			// KBS1 채널보다 KBS2 채널이 앞서 있었던 경우 KBS2 채널의 초기 위치를 조정
			if (chKBS1 > chKBS2)
				chKBS2++;
		}
		
		// KBS2 채널이 두 번째에 위치하지 않는 경우
		if (chKBS2 != 2) {
			
			// for 반복문을 사용해 KBS2 채널의 위치로 보내는 1번 버튼을 sb에 추가
			for (int count = 0; count < chKBS2 - 1; count++)
				sb.append(1);
			
			// for 반복문을 사용해 두 번째 위치로 KBS2 채널을 올려 보내는 4번 버튼을 sb에 추가
			for (int count = 0; count < chKBS2 - 2; count++)
				sb.append(4);
		}
		
		// toString() 및 write() 메서드를 사용해 상근이가 눌러야 하는 버튼을 순서대로 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}