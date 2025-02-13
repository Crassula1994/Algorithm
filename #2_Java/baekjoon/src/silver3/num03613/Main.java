package silver3.num03613;

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
		
		// readLine() 메서드를 사용해 입력 받은 변수명을 변수 variableName에 할당
		String variableName = in.readLine();
		
		// variableClassifier() 메서드를 호출해 해당 변수가 어떤 언어 형식인지를 변수 category에 할당
		String category = variableClassifier(variableName);
		
		// 에러인 경우 'Error!'를 출력
		if (category.equals("Error")) {
			out.write("Error!");
			
		// C++ 형식인 경우 Java 형식으로 변환한 결과를 출력
		} else if (category.equals("C++")) {
			out.write(cppConverter(variableName));
			
		// Java 형식인 경우 C++ 형식으로 변환한 결과를 출력
		} else {
			out.write(javaConverter(variableName));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// variableClassifier() 메서드 정의
	public static String variableClassifier(String variableName) {
		
		// 대문자 또는 밑줄의 포함 여부를 저장할 각 변수 초기화
		boolean hasUppercase = false;
		boolean hasUnderscore = false;
		
		// for 반복문을 사용해 각 글자를 순회
		for (int idx = 0; idx < variableName.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 글자를 변수 character에 할당
			char character = variableName.charAt(idx);
			
			// 해당 글자가 대문자인 경우 대문자 포함 여부를 갱신
			if (character >= 'A' && character <= 'Z')
				hasUppercase = true;
			
			// 해당 글자가 밑줄인 경우 밑줄 포함 여부를 갱신
			if (character == '_')
				hasUnderscore = true;
		}
		
		// 대문자와 밑줄이 혼재하는 경우 'Error'를 반환
		if (hasUppercase && hasUnderscore)
			return "Error";
		
		// 밑줄만 존재하는 경우 'C++'를 반환
		if (hasUnderscore)
			return "C++";
		
		// 대문자만 존재하거나 대문자도 밑줄도 존재하지 않는 경우 'Java'를 반환
		return "Java";
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// cppConverter() 메서드 정의
	public static String cppConverter(String variableName) {
		
		// 밑줄로 시작하거나 밑줄로 끝나거나 밑줄이 연속되는 경우 'Error!'를 반환
		if (variableName.startsWith("_") || variableName.endsWith("_") || variableName.contains("__"))
			return "Error!";
		
		// 변수명을 Java 형식으로 바꾼 결과를 저장할 StringBuilder 객체 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 글자를 순회
		for (int idx = 0; idx < variableName.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 글자를 변수 character에 할당
			char character = variableName.charAt(idx);
			
			// 해당 글자가 밑줄인 경우 다음 글자를 대문자로 변환해 sb에 저장
			if (character == '_') {
				sb.append(Character.toUpperCase(variableName.charAt(idx++ + 1)));
				
			// 해당 글자가 알파벳 소문자인 경우 그대로 sb에 저장
			} else {
				sb.append(character);
			}
		}
		
		// toString() 메서드를 사용해 변수명을 Java 형식으로 바꾼 결과를 반환
		return sb.toString();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// javaConverter() 메서드 정의
	public static String javaConverter(String variableName) {
		
		// 알파벳 대문자로 시작하는 경우 'Error!'를 반환
		if (variableName.charAt(0) < 'a')
			return "Error!";
		
		// 변수명을 C++ 형식으로 바꾼 결과를 저장할 StringBuilder 객체 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 글자를 순회
		for (int idx = 0; idx < variableName.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 글자를 변수 character에 할당
			char character = variableName.charAt(idx);
			
			// 해당 글자가 알파벳 대문자인 경우 해당 글자를 소문자로 변환해 밑줄과 함께 sb에 저장
			if (character < 'a') {
				sb.append("_").append(Character.toLowerCase(character));
				
			// 해당 글자가 알파벳 소문자인 경우 그대로 sb에 저장
			} else {
				sb.append(character);
			}
		}
		
		// toString() 메서드를 사용해 변수명을 C++ 형식으로 바꾼 결과를 반환
		return sb.toString();
	}
}