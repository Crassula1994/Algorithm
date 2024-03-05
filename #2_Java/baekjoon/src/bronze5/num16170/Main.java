package bronze5.num16170;

// 필요한 패키지 불러오기
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedWriter 객체를 불러와 변수 out에 할당
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// now() 메서드를 사용해 세계 표준시를 기준으로 현재 시간을 변수 curTime에 할당
		ZonedDateTime curTime = ZonedDateTime.now(ZoneOffset.UTC);
		
		// getYear(), getMonthValue(), getDayOfMonth(), write() 메서드를 사용해 현재 날짜를 차례로 출력
		out.write(curTime.getYear() + "\n" + curTime.getMonthValue() + "\n" + curTime.getDayOfMonth());
		
		// close() 메서드를 사용해 BufferedWriter 객체 종료
		out.close();
	}
}