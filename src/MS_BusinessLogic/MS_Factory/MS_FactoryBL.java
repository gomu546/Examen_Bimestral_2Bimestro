//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package MS_BusinessLogic.MS_Factory;

import java.util.List;

import MS_DataAccess.MS_Interfaces.IDAO;
import MS_Infrastructure.MS_AppException;

public class MS_FactoryBL<T> {
    private final IDAO<T> oDAO;

    public MS_FactoryBL(Class<? extends IDAO<T>> classDAO) {
        try {
            this.oDAO = classDAO.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            MS_AppException er = new MS_AppException("Error al instanciar classDAO<T>", e, getClass(),
                    "FactoryBL(<T>)");
            throw new RuntimeException(er);
        }
    }

    // Constructor que usa un Supplier para crear la instancia de T
    // public FactoryBL(Supplier<IDAO<T>> supplier) {
    // this.oDAO = supplier.get();
    // }

    public List<T> getAll() throws MS_AppException {
        return oDAO.readAll();
    }

    public T getBy(Integer id) throws MS_AppException {
        return oDAO.readBy(id);
    }

    public boolean add(T oT) throws MS_AppException {
        return oDAO.create(oT);
    }

    public boolean upd(T oT) throws MS_AppException {
        return oDAO.update(oT);
    }

    public boolean del(Integer id) throws MS_AppException {
        return oDAO.delete(id);
    }

    public Integer getMaxReg(String cellName) throws MS_AppException {
        return oDAO.getMaxReg(cellName);
    }

    public Integer getMinReg(String cellName) throws MS_AppException {
        return oDAO.getMinReg(cellName);
    }

    public Integer getCountReg() throws Exception {
        return oDAO.getCountReg();
    }
}
