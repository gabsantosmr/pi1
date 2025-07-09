<template>
  <div class="calculator">
    <h2>Calculadora</h2>
    <div class="inputs">
      <input v-model.number="a" type="number" placeholder="Valor A" />
      <input v-model.number="b" type="number" placeholder="Valor B" />
    </div>
    <div class="buttons">
      <button @click="calcular('soma')">Somar</button>
      <button @click="calcular('subtracao')">Subtrair</button>
      <button @click="calcular('multiplicacao')">Multiplicar</button>
      <button @click="calcular('divisao')">Dividir</button>
    </div>
    <div v-if="resultado !== null" class="result">
      <strong>Resultado:</strong> {{ resultado }}
    </div>
    <div v-if="erro" class="error">
      <strong>Erro:</strong> {{ erro }}
    </div>
  </div>
</template>

<script>
export default {
  name: 'Calculadora',
  data() {
    return {
      a: null,
      b: null,
      resultado: null,
      erro: ''
    };
  },
  methods: {
    async calcular(operacao) {
      this.resultado = null;
      this.erro = '';
      if (this.a === null || this.b === null) {
        this.erro = 'Preencha ambos os valores.';
        return;
      }
      try {
        const response = await fetch(`http://localhost:8080/calculadora/${operacao}/${this.a}/${this.b}`);
        if (!response.ok) throw new Error('Erro ao calcular');
        const result = await response.json();
        this.resultado = result;
      } catch (e) {
        this.erro = 'Não foi possível calcular.';
      }
    }
  }
};
</script>

<style scoped>
.calculator {
  max-width: 400px;
  margin: 40px auto;
  padding: 24px;
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.1);
  text-align: center;
}
.inputs {
  margin-bottom: 16px;
}
.inputs input {
  width: 100px;
  margin: 0 8px;
  padding: 8px;
  font-size: 1rem;
}
.buttons button {
  margin: 8px 4px;
  padding: 8px 16px;
  font-size: 1rem;
  border: none;
  border-radius: 4px;
  background: #1976d2;
  color: #fff;
  cursor: pointer;
  transition: background 0.2s;
}
.buttons button:hover {
  background: #1565c0;
}
.result {
  margin-top: 20px;
  font-size: 1.2rem;
  color: #388e3c;
}
.error {
  margin-top: 20px;
  color: #d32f2f;
}
</style>
