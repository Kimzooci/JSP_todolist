
package kyungseo.poc.todo.common.base;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class PagingResultDto<DTO, EN> {

    // DTO 리스트
    private List<DTO> DTOs;

    // 총 페이지 번호
    private int totalPage;

    // 현재 페이지 번호
    private int pageNum;

    // 목록 사이즈
    private int pageSize;

    // 시작 페이지 번호
    private int start;

    // 끝 페이지 번호
    private int end;

    // 이전
    private boolean prev;

    // 다음
    private boolean next;

    //페이지 번호 목록
    private List<Integer> pageList;

    public PagingResultDto(Page<EN> result, Function<EN,DTO> fn) {
        DTOs = result.stream().map(fn).collect(Collectors.toList());
        totalPage = result.getTotalPages();
        pageNum = result.getPageable().getPageNumber() + 1; // 0 부터 시작하므로 1을 추가
        pageSize = result.getPageable().getPageSize();

        // temp end page
        int tempEnd = (int) (Math.ceil(pageNum / 10.0)) * 10;

        start = tempEnd - 9;
        prev = start > 1;
        end = totalPage > tempEnd ? tempEnd : totalPage;
        next = totalPage > tempEnd;
        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }

}
