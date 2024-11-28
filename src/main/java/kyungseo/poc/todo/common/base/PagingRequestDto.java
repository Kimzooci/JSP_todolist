
package kyungseo.poc.todo.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import kyungseo.poc.todo.common.config.EnvironmentAwareConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class PagingRequestDto {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private Integer pageNum;

    private Integer pageSize;

    private String searchType;

    private String searchKeyword;

    public PagingRequestDto() {
        this.pageNum = 1;
        this.pageSize = Integer.parseInt(
                EnvironmentAwareConfig.getProperty("app.paging.size.default"));
    }

    public Integer getLimit() {
        return pageSize;
    }

    public Integer getOffset() {
        return pageSize * pageNum - pageSize;
    }

    public Pageable getPageable() {
        LOGGER.debug("> pageNum: " + pageNum);
        LOGGER.debug("> pageSize: " + pageSize);
        return PageRequest.of(pageNum -1, pageSize);
    }

    public Pageable getPageable(Sort sort) {
        LOGGER.debug("> pageNum: " + pageNum);
        LOGGER.debug("> pageSize: " + pageSize);
        return PageRequest.of(pageNum -1, pageSize, sort);
    }

}
