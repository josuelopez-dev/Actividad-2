package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Paciente;

public class PacienteDao {

    Conexion conn;

    public PacienteDao(Conexion conn) {
        this.conn = conn;
    }

    //metodo para insertar en la base de datos
    public boolean insertar(Paciente pac) {
        String sql = "insert into paciente values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, pac.getIdMascota());
            ps.setString(2, pac.getAliasMascota());
            ps.setString(3, pac.getEspecie());
            ps.setString(4, pac.getRaza());
            ps.setString(5, pac.getColorPelo());
            ps.setDate(6, pac.getFechaNacimiento());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //metodo para listar los registros
    public List<Paciente> selectAll() {
        String sql = "select * from paciente";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Paciente> lista = new LinkedList<>();
            Paciente pac;
            while (rs.next()) {
                pac = new Paciente(rs.getInt("idMascota"));
                pac.setAliasMascota(rs.getString("aliasMascota"));
                pac.setEspecie(rs.getString("especie"));
                pac.setRaza(rs.getString("raza"));
                pac.setColorPelo(rs.getString("colorPelo"));
                pac.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                lista.add(pac);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    //metodo para consultar un registro
    public List<Paciente> selectById(int id) {
        String sql = "select * from paciente where idMascota = ?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Paciente pac;
            List<Paciente> lista = new LinkedList<>();

            while (rs.next()) {
                pac = new Paciente(rs.getInt("idMascota"));
                pac.setAliasMascota(rs.getString("aliasMascota"));
                pac.setEspecie(rs.getString("especie"));
                pac.setRaza(rs.getString("raza"));
                pac.setColorPelo(rs.getString("colorPelo"));
                pac.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                lista.add(pac);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

}
