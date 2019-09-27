package ru.javabegin.training.web.entity.ext;

public class GenreExt extends ru.javabegin.training.web.entity.Genre implements java.io.Serializable {

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (super.getId() != null ? super.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GenreExt other = (GenreExt) obj;
        if (super.getId() != other.getId() && (super.getId() == null || !super.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.getName();
    }




}


