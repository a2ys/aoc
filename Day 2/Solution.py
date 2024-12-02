def check_safe(numbers: list) -> bool:
    if len(numbers) < 2:
        return False

    safe_differences = {1, 2, 3}
    direction = None

    for i in range(1, len(numbers)):
        diff = numbers[i] - numbers[i - 1]

        if diff == 0:
            return False

        if direction is None:
            direction = 1 if diff > 0 else -1

        if (direction == 1 and diff <= 0) or (direction == -1 and diff >= 0):
            return False

        if abs(diff) not in safe_differences:
            return False

    return True


safe_reports = 0

with open("input.txt", "r") as file:
    for line in file:
        current_line = [int(number) for number in line.split()]
        if check_safe(current_line):
            safe_reports += 1

print(safe_reports)

