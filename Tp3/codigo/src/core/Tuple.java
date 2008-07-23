package core;

/**
 * Clase Generica Tupla.
 * 
 * @author Grupo2
 *
 * @param <T1> tipo del primer objeto
 * @param <T2> tipo del segundo objeto
 */
public class Tuple<T1, T2> {
        
		private T1 primero;
		private T2 segundo;

        
        public Tuple(T1 first, T2 second) {
                this.primero = first;
                this.segundo = second;
        }


		public T1 getPrimero() {
			return primero;
		}


		public void setPrimero(T1 primero) {
			this.primero = primero;
		}


		public T2 getSegundo() {
			return segundo;
		}


		public void setSegundo(T2 segundo) {
			this.segundo = segundo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((primero == null) ? 0 : primero.hashCode());
			result = prime * result
					+ ((segundo == null) ? 0 : segundo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Tuple other = (Tuple) obj;
			if (primero == null) {
				if (other.primero != null)
					return false;
			} else if (!primero.equals(other.primero))
				return false;
			if (segundo == null) {
				if (other.segundo != null)
					return false;
			} else if (!segundo.equals(other.segundo))
				return false;
			return true;
		}
		
		
        
        
}
