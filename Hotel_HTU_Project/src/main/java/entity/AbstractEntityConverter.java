package entity;

import javax.persistence.Table;

public abstract class AbstractEntityConverter {
	
	public abstract Integer getId();

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractEntityConverter) {
			AbstractEntityConverter EntityConverter = (AbstractEntityConverter) obj;
			String entityConverterTableName = EntityConverter.getClass().getAnnotation(Table.class).name();
			String currentTableName = getClass().getAnnotation(Table.class).name();
			if (entityConverterTableName.equals(currentTableName)) {
				if (EntityConverter.getId() == getId()) {
					return true;
				}
			}
		}
		return false;
	}

}
