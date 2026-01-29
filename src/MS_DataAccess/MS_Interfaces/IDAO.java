//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package MS_DataAccess.MS_Interfaces;

import java.util.List;

import MS_Infrastructure.MS_AppException;

public interface IDAO<T> {
    List<T> readAll() throws MS_AppException;

    T readBy(Integer id) throws MS_AppException;

    boolean create(T entity) throws MS_AppException;

    boolean update(T entity) throws MS_AppException;

    boolean delete(Integer id) throws MS_AppException;

    Integer getCountReg() throws MS_AppException;

    Integer getMinReg(String tableCelName) throws MS_AppException;

    Integer getMaxReg(String tableCelName) throws MS_AppException;
}
