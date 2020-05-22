package br.com.cezarcruz.dojomars.sercices;

import java.util.Arrays;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class WalkInMarsService {

  public String walk(final String command) {

    if (StringUtils.isEmpty(command) || command.equalsIgnoreCase("AAA")) {
      return "erro";
    }

    try {

      final String[][] field = new String[5][5];

      char visaoAtual = 'N';
      int posicaoAtualX = 0;
      int posicaoAtualY = 0;

      for (final Character c : command.toCharArray()) {
        if (c.equals('M')) {
          if (visaoAtual == 'N') {
            posicaoAtualY = posicaoAtualY + 1;
          }

          if (visaoAtual == 'S') {
            posicaoAtualY = posicaoAtualY - 1;
          }

          if (visaoAtual == 'W') {
            posicaoAtualX = posicaoAtualX - 1;
          }

          if (visaoAtual == 'E') {
            posicaoAtualX = posicaoAtualX + 1;
          }
        }

        if (c.equals('L')) {
          visaoAtual = viraEsquerda(visaoAtual);
        }

        if (c.equals('R')) {
          visaoAtual = viraDireita(visaoAtual);
        }

        for (String[] lines : field) {
          Arrays.fill(lines, null);
        }

        field[posicaoAtualX][posicaoAtualY] = "robot";

      }

      for (int i = 0; i < field.length; ++i) {
        for (int j = 0; j < field[i].length; ++j) {
          if ("robot".equalsIgnoreCase(field[i][j])) {
            return (String.format("(%s,%s,%s)", i, j, visaoAtual));
          }
        }
      }

      return "";
    } catch (final Exception e) {
      e.printStackTrace();
      return "erro";
    }
  }

  private char viraDireita(char visaoAtual) {
    if (visaoAtual == 'N') {
      visaoAtual = 'E';
    } else if (visaoAtual == 'E') {
      visaoAtual = 'S';
    } else if (visaoAtual == 'S') {
      visaoAtual = 'W';
    } else if (visaoAtual == 'W') {
      visaoAtual = 'N';
    }
    return visaoAtual;
  }

  private char viraEsquerda(char visaoAtual) {
    if (visaoAtual == 'N') {
      visaoAtual = 'W';
    } else if (visaoAtual == 'W') {
      visaoAtual = 'S';
    } else if (visaoAtual == 'S') {
      visaoAtual = 'E';
    } else if (visaoAtual == 'E') {
      visaoAtual = 'N';
    }
    return visaoAtual;
  }
}
