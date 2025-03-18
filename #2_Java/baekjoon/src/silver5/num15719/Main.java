package silver5.num15719;

// 필요한 패키지 불러오기
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 한 번에 확인할 입력의 크기를 저장할 상수 BUFFER_SIZE 초기화
	static final int BUFFER_SIZE = 79_000_000;
	
	// 현재 확인 중인 입력의 위치를 저장할 배열 bufferIdx 초기화
	static int bufferIdx = 0;
	
	// 한 번에 확인할 입력의 크기를 저장할 배열 buffer 초기화
	static byte[] buffer = new byte[BUFFER_SIZE];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// InputStream 및 BufferedWriter 객체를 불러와 각 변수에 할당
		InputStream in = System.in;
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// read() 메서드를 사용해 데이터를 입력 받아 배열 buffer에 차례로 저장
		in.read(buffer, 0, buffer.length);
		
		// nextNumber() 메서드를 사용해 입력 받은 수열의 크기를 변수 size에 할당
		long size = nextNumber();
		
		// 수열의 원소의 총합을 저장할 변수 sum 초기화
		long sum = 0;
		
		// for 반복문을 사용해 수열의 원소의 총합을 갱신
		for (int element = 0; element < size; element++)
			sum += nextNumber();
		
		// valueOf() 및 write() 메서드를 사용해 중복된 숫자를 출력
		out.write(String.valueOf(sum - size * (size - 1) / 2));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// nextNumber() 메서드 정의
	public static int nextNumber() {
		
		// 입력 받은 숫자를 저장할 변수 result 초기화
		int result = 0;
		
		// while 반복문을 사용해 현재 문자가 숫자가 아닌 경우 다음 문자로 이동
		while (buffer[bufferIdx] < '0')
			bufferIdx++;
		
		// while 반복문을 사용해 입력 받은 숫자를 갱신
		while (buffer[bufferIdx] >= '0')
			result = result * 10 + buffer[bufferIdx++] - '0';
		
		// 입력 받은 숫자를 반환
		return result;
	}
}