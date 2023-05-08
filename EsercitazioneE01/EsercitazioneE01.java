package it.corsojava.jdbc;

import java.sql.*;

public class EsercitazioneE01 {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/corsosql";
        try(Connection cn = DriverManager.getConnection(url, "corsosql", "corsosql")){
            StringBuilder sql = new StringBuilder();
            sql.append("select L.idlibro , L.isbn , L.titolo , A.cognome ,A.nome ");
            sql.append("from libri L ");
            sql.append("left join autori A on L.idautore =A.idautore ");
            sql.append("where L.annoedizione = 1892;");

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql.toString());
            while(rs.next()){
                int idlibro= rs.getInt(1);
                String isbn=rs.getString(2);
                String titolo =rs.getString(3);
                String cognome=rs.getString("cognome");
                String nome=rs.getString("nome");
                System.out.println(idlibro + ", " + isbn+ ", "+cognome+" "+nome+", "+ titolo);
            }
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}
