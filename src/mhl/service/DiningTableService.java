package mhl.service;

import mhl.dao.DiningTableDAO;
import mhl.domain.DiningTable;

import java.util.List;

/**
 * @ author   lyg
 * @ version  1.0
 */
public class DiningTableService {
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    public List<DiningTable> list() {
        return diningTableDAO.queryMulti("select id, state from diningtable", DiningTable.class);
    }

    public DiningTable getDiningTableById(int id) {
        return diningTableDAO.querySingle("select * from diningTable where id = ?", DiningTable.class, id);
    }

    public boolean orderDiningTable(int id, String orderName, String orderTel) {
        int update = diningTableDAO.update("update diningTable set state = '已经预定', orderName = ?, orderTel = ? where id = ?", orderName, orderTel, id);
        return update > 0;
    }
    public boolean updateDiningTableState(int id, String state) {
        int update = diningTableDAO.update("update diningTable set state = ? where id = ?", state, id);
        return update > 0;
    }

    public boolean updateDiningTableToFree(int id) {
        int update = diningTableDAO.update("update diningTable set state = '空', orderName = '', orderTel = '' where id = ?", id);
        return update > 0;
    }
}
